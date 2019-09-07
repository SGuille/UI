package ar.com.unqui.practica2.Ejercicio4

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.Entity
import org.uqbar.commons.model.annotations.Observable
import org.uqbar.commons.model.annotations.Transactional

@Observable
@Accessors
@Transactional
class Cliente(var nombre: String = "", var apellido: String = ""): Entity() {

}
