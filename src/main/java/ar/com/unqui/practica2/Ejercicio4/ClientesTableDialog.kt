package ar.com.unqui.practica2.Ejercicio4

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.WindowOwner

class ClientesTableDialog(owner: WindowOwner, model: Compania) : Dialog<Compania>(owner, model) {

    override fun createFormPanel(mainPanel: Panel) {
        title = "Clientes"

        table<Cliente>(mainPanel) {
            bindItemsTo("clientes")
            visibleRows = 5
            column {
                title = "Nombre"
                fixedSize = 200
                bindContentsTo("nombre")
            }
            column {
                title = "Apellido"
                fixedSize = 200
                bindContentsTo("apellido")
            }
        }
    }
}
