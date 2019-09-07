package ar.com.unqui.practica2.Ejercicio3

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class IngreseApellidoDialog: Dialog<CargarDatosModel> {

    constructor(owner: WindowOwner, model: CargarDatosModel) : super(owner, model)

    override fun createFormPanel(mainPanel: Panel?) {
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with {
                text = "Ingrese su apellido:"
            }
            TextBox(it) with {
                bindTo("apellido")
            }
        }
        Button(mainPanel) with {
            caption = "Aceptar"
            onClick { accept() }
        }
    }
}
