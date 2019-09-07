package ar.com.unqui.practica2.Ejercicio4

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.annotations.Observable

@Accessors
@Observable
class Compania(var clientes: MutableList<Cliente>) {

//    var clientes: MutableList<Cliente> = ArrayList<Cliente>()
    fun agregarCliente(cliente: Cliente) = clientes.add(cliente)
}

object CompaniaFactory {
    fun get(): Compania {
        val c1 = Cliente("Guille", "Salvatore")
        val c2 = Cliente("Pepe", "Argento")
        val c3 = Cliente("Carlos", "Gomez")
        val c4 = Cliente("Juan", "Perez")
        return Compania(mutableListOf(c1,c2,c3,c4))
    }
}
