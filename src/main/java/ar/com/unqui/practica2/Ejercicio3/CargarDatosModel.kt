package ar.com.unqui.practica2.Ejercicio3

import org.uqbar.commons.model.annotations.Observable

@Observable
class CargarDatosModel {
    var nombre = ""
    var apellido = ""

    fun limpiar() {
        nombre = ""
        apellido = ""
    }

}
