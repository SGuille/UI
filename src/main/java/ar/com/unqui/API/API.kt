package ar.com.unqui.API

import data.DigitalWalletData
import io.javalin.Javalin
import io.javalin.http.NotFoundResponse
import org.omg.CORBA.UserException
import wallet.DigitalWallet
import wallet.LoginException
import wallet.User

fun main(args: Array<String>) {
    val app: Javalin = Javalin.create().start(7001)
    var controller = Controller()
    app.post("api/login"){ctx ->

//        Tengo los parametros del body
        val loginWrapper = ctx.body<LoginWrapper>()
//        Llamar al modelo
        var userWrapper: UserWrapper? = controller.login(loginWrapper)
        if (userWrapper != null) {
            ctx.status(200)
            ctx.json(userWrapper)
        }else {
            ctx.status(401)
//            ctx.json("usuario o password incorrecto")
        }
    }

    app.post("api/register") {ctx ->

        var registerWrapper = ctx.body<RegisterWrapper>()
        val usuarioExistente = controller.users.any{ it.email == registerWrapper.email }

        if (!usuarioExistente) {
            controller.register(registerWrapper)
            ctx.status(200)
            ctx.json("Registrado")
        } else {
            ctx.status(400)
            ctx.json(Handler(400, "Bad request", "Username existente"))
        }
    }

    app.get("api/usuarios/:usuario"){ctx ->
        var usuario = ctx.pathParam("usuario")
        val userEncontrado = controller.users.firstOrNull { it.email == usuario } ?: throw NotFoundResponse("Usuario no encontrado")
        var userRes = RegisterWrapper(userEncontrado.password, userEncontrado.email, userEncontrado.idCard, userEncontrado.firstName, userEncontrado.lastName)
        ctx.json(userRes)
    }

    app.get("api/account/:cvu") {ctx ->
        var cvu = ctx.pathParam("cvu")
        val usuarioExistente = controller.getUserByCVU(cvu)
        var saldo: Double? = 2.2

        if(usuarioExistente != null) {
            saldo = usuarioExistente.account?.balance
            if (saldo != null) {
                ctx.json(AccountAdapter(saldo))
            }
            ctx.status(200)
        } else {
            ctx.status(400)
        }
        print(cvu)
        print(saldo)
    }

    app.get("api/usuarios/transaccions/:cvu"){ctx ->
        var cvu = ctx.pathParam("cvu")
        val usuarioExistente = controller.getUserByCVU(cvu)
        var transaccions: MutableList<wallet.Transactional>

        if(usuarioExistente != null) {
            transaccions = usuarioExistente.account?.transactions!!
            val transaccionsRes = TransansaccionsAdapter(transaccions)
            ctx.json(transaccions)
            ctx.status(200)
        } else {
            ctx.status(400)
        }
    }

    app.delete("api/usuarios/:cvu") {ctx ->
        val usuarioExistente = controller.getUserByCVU(ctx.pathParam("cvu"))
        if(usuarioExistente != null) {
            controller.delete(usuarioExistente)
            ctx.json(usuarioExistente)
            ctx.status(200)
        }else {
            ctx.status(400)
            ctx.json(Handler(400, "Bad request", "usuario inexistente"))
        }
    }
}

class Controller {
    private val digitalWallet : DigitalWallet = DigitalWalletData.build()
    val users = digitalWallet.users

    fun login(loginWrapper: LoginWrapper): UserWrapper? {
        try {
           return UserWrapper(digitalWallet.login(loginWrapper.usuario, loginWrapper.password))
        }catch (e:LoginException) {
            print(e)
        }
        return null
    }

    fun register(registerWrapper: RegisterWrapper) {
        try {
            digitalWallet.register(registerWrapper.toUser())
        } catch (e: UserException) {
            print(e)
        }
    }

    fun getUserByCVU(cvu: String): User {
        return users.firstOrNull { it.account?.cvu == cvu } ?: throw NotFoundResponse("Usuario no encontrado")
    }

    fun delete(user: User) {
        digitalWallet.deleteUser(user)
    }
}

open class Handler(val code: Int, val type: String, open val message: String)
