package ar.com.unqui.practica2.Ejercicio2

import org.uqbar.arena.kotlin.extensions.bindTo
import org.uqbar.arena.kotlin.extensions.caption
import org.uqbar.arena.kotlin.extensions.text
import org.uqbar.arena.kotlin.extensions.with
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class CalculatorWindow: SimpleWindow<CalculatorModel> {

    constructor(owner: WindowOwner, model: CalculatorModel) : super(owner, model)

    override fun addActions(p0: Panel?) {
    }

    override fun createFormPanel(mainPanel: Panel?) {
        title = "Calculadora"
        Label(mainPanel) with {
            text = "Ingrese el operador 1"
        }

        NumericField(mainPanel) with {
            bindTo("operadorUno")
        }

        Label(mainPanel) with {
            text = "Ingrese el operador 2"
        }

        NumericField(mainPanel) with {
            bindTo("operadorDos")
        }

        Button(mainPanel) with {
            caption = "Sumar"
            onClick { modelObject.sumar() }
        }

        Button(mainPanel) with {
            caption = "Restar"
            onClick { modelObject.restar() }
        }

        Button(mainPanel) with {
            caption = "Multiplicar"
            onClick { modelObject.multiplicar() }
        }

        Button(mainPanel) with {
            caption = "Dividir"
            onClick { modelObject.dividir() }
        }

        TextBox(mainPanel) with {
            bindTo("total")
        }
    }
}
