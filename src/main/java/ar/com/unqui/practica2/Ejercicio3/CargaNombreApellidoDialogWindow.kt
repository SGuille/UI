package ar.com.unqui.practica2.Ejercicio3

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.lacar.ui.model.Action

class CargaNombreApellidoDialogWindow(owner: WindowOwner, model: CargarDatosModel) : Dialog<CargarDatosModel>(owner, model) {

    override fun createFormPanel(mainPanel: Panel?) {
        Label(mainPanel) with {
            text ="Su nombre es:"
        }
        Label(mainPanel) with {
            bindTo("nombre")
        }
        Button(mainPanel) with {
            caption = "Agregar nombre"
            onClick { IngresarNombreDialog(thisWindow, modelObject).open() }
        }
        Label(mainPanel) with {
            text ="Su apellido es:"
        }
        Label(mainPanel) with {
            bindTo("apellido")
        }
        Button(mainPanel) with {
            caption = "Agregar apellido"
            onClick { IngreseApellidoDialog(thisWindow, modelObject).open() }
        }
        Button(mainPanel) with {
            caption = "Cerrar"
            onClick {
                modelObject.limpiar()
                cancel()
            }
        }
    }
}
