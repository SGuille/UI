package ar.com.unqui

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.arena.kotlin.extensions.*

class AplicacionPrueba : Application() {

    override fun createMainWindow(): Window<*> {
        return WindowPrueba(this, PruebaModelo())
    }
}

fun main() {
    AplicacionPrueba().start()
}
