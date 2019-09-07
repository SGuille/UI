package ar.com.unqui.practica2.Ejercicio4

import org.uqbar.arena.aop.windows.`DialogTrait$class`.onAccept
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.windows.WindowOwner

fun main() = CompaniaWindow(CompaniaModel(CompaniaFactory.get())).startApplication()

class CompaniaWindow(model: CompaniaModel): MainWindow<CompaniaModel>(model) {

    override fun createContents(mainPanel: Panel) {
        title = "Compania"
        setMinWidth(150)
        ErrorsPanel(mainPanel,"")
        Panel(mainPanel) with {
            asHorizontal()
            Label(it) with { text = "Filtrar:"}
            TextBox(it) bindTo "filter"
            Button(it) with {
                caption = "Crear nuevo"
                onClick {
                    val nuevoCliente = Cliente()
                    InformacionClienteWindow(thisWindow, nuevoCliente) with {
                        onAccept { agregarCliente(nuevoCliente)}
                        open()
                    }
                }
            }
            Button(it) with {
                caption = "Editar"
                onClick {
                    InformacionClienteWindow(thisWindow, thisWindow.modelObject.clienteSeleccionado).open()
                }
            }
        }
        crearTablaClientes(mainPanel)
    }

    private fun crearTablaClientes(mainPanel: Panel) {
        table<Cliente>(mainPanel) with {
            visibleRows = 5
            bindItemsTo("clientesCompania")
            bindSelectionTo("clienteSeleccionado")
            column {
                title = "Nombre"
                fixedSize = 100
                bindContentsTo("nombre")
            }
            column {
                title = "Apellido"
                fixedSize = 100
                bindContentsTo("apellido")
            }
        }
    }

    private fun agregarCliente(cliente: Cliente) = modelObject.agregarcliente(cliente)
}
