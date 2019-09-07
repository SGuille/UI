package ar.com.unqui.practica2.Ejercicio1

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.arena.kotlin.extensions.*

class ApplicationLogin: Application() {

    override fun createMainWindow(): Window<*> {
        return LoginWindow(this, LoginModel())
    }
}

fun main() {
    ApplicationLogin().start()
}
