package ar.com.unqui.practica2.Ejercicio1

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.kotlin.extensions.*

class LoginWindow : SimpleWindow<LoginModel> {

    constructor(owner: WindowOwner, model: LoginModel) : super(owner, model)

    override fun createFormPanel(mainPanel: Panel?) {
        title = "Login de usuario"
        Label (mainPanel) with {
            text = "Ingrese el usuario"
        }

        TextBox(mainPanel) with {
            bindTo("msg")
        }

        Label(mainPanel) with {
            text = "Ingrese el password"
        }

        PasswordField(mainPanel) with {
            bindTo("password")
        }

        Button(mainPanel) with {
            caption = "Autenticar"
            onClick { modelObject.validar() }
        }

        Label(mainPanel) with {
            bindTo("validated")
            bindBackgroundTo("bgColorValidated")
        }
    }

    override fun addActions(p0: Panel?) {
    }
}
