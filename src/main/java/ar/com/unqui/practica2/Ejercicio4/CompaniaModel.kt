package ar.com.unqui.practica2.Ejercicio4

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class CompaniaModel(var compania: Compania) {
    var clientesCompania: MutableList<Cliente> = compania.clientes.toMutableList()
    var clienteSeleccionado: Cliente? = null
    var filter: String? = ""
        set(value) {
            field = value.toString().toLowerCase()
            buscar()
        }

    fun agregarcliente(cliente: Cliente) {
        compania.agregarCliente(cliente)
        buscar()
    }

    private fun buscar() {
        clientesCompania = compania.clientes.filter { it.nombre.toLowerCase().contains(filter.toString()) }.toMutableList()
    }
}
