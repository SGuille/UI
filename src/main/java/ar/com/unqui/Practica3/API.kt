package ar.com.unqui.Practica3

import data.DigitalWalletData
import io.javalin.Javalin
import wallet.DigitalWallet
import wallet.LoginException

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
            ctx.json("usuario o password incorrecto")
        }
    }
    app.get("api/usuarios/:usuario"){ctx ->
        var usuario = ctx.pathParam("usuario")
        var nombre = ctx.pathParam("nombre")
        print(usuario)
        print(nombre)
    }
}

class Controller {
    private val digitalWallet : DigitalWallet = DigitalWalletData.build()

    fun login(loginWrapper: LoginWrapper): UserWrapper? {
        try {
           return UserWrapper(digitalWallet.login(loginWrapper.usuario, loginWrapper.password))
        }catch (e:LoginException) {
            print(e)
        }
        return null
    }

}
