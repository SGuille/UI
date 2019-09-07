package ar.com.unqui.practica2.Ejercicio2

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.arena.kotlin.extensions.*

class ApplicationCalculator: Application() {

    override fun createMainWindow(): Window<*> {
        return CalculatorWindow(this, CalculatorModel())
    }
}

fun main() {
    ApplicationCalculator().start()
}
