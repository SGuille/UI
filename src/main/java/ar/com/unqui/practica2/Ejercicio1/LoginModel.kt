package ar.com.unqui.practica2.Ejercicio1

import org.uqbar.commons.model.annotations.Observable
import java.awt.Color
import org.uqbar.arena.kotlin.extensions.*

@Observable
class LoginModel {
    var msg = ""
    var password = ""
    var validated = "false"
    var bgColorValidated = Color.YELLOW

    fun validar() {
        if (msg != "" && password != "") {
            println("Login validado para usuario: $msg")
            validated = "true"
            bgColorValidated = Color.GREEN
        }
    }
}
