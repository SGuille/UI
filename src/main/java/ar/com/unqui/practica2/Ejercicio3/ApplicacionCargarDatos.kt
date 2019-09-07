package ar.com.unqui.practica2.Ejercicio3

import org.uqbar.arena.Application
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.windows.Window

class AplicacionCargarDatos: Application() {

    override fun createMainWindow(): Window<*> {
        return CargarDatosWindow(this, CargarDatosModel())
    }
}

fun main() {
    AplicacionCargarDatos().start()
}
