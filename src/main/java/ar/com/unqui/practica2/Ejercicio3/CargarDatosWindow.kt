package ar.com.unqui.practica2.Ejercicio3

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

class CargarDatosWindow(owner: WindowOwner, model: CargarDatosModel): SimpleWindow<CargarDatosModel>(owner,model) {

    override fun addActions(mainPanel: Panel?) {
    }

    override fun createFormPanel(mainPanel: Panel?) {
        title = "Carga datos"
        Panel(mainPanel) with {
            asVertical()
            Label(it) with {
                text = "Aplicaión para almacenar Nombre y Apellido"
            }
        }

        Button(mainPanel) with {
            caption = "Cargar Datos"
            onClick {
                CargaNombreApellidoDialogWindow(thisWindow, modelObject).open()
            }
        }
    }

}
