package ar.com.unqui.practica2.Ejercicio2

import org.uqbar.commons.model.annotations.Observable

@Observable
class CalculatorModel {

    var operadorUno = 0
    var operadorDos = 0
    var total = 0

    fun sumar() {
        total = operadorUno + operadorDos
    }

    fun restar() {
        total = operadorUno - operadorDos
    }

    fun multiplicar() {
        total = operadorUno * operadorDos
    }

    fun dividir() {
        if (operadorDos != 0) {
            total = operadorUno / operadorDos
        }
    }

}
