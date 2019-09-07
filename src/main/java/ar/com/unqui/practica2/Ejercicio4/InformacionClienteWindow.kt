package ar.com.unqui.practica2.Ejercicio4

import org.uqbar.arena.aop.windows.TransactionalDialog
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner

class InformacionClienteWindow(owner: WindowOwner, model: Cliente?) : TransactionalDialog<Cliente>(owner,model) {
    override fun createFormPanel(mainPanel: Panel) {
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with { text = "Nombre:"}
            TextBox(it) bindTo "nombre"
        }
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with { text = "Apellido"}
            TextBox(it) bindTo "apellido"
        }
        Button(mainPanel) with {
            caption = "Aceptar"
            onClick { accept() }
        }
    }

}
