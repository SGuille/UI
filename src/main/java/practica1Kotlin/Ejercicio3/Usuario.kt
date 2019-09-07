package practica1Kotlin.Ejercicio3

import java.time.LocalDate
import java.time.temporal.ChronoUnit

class Usuario(nombreCompleto: String, nombreUsuario: String, email: String, fechaNacimiento: LocalDate) {

    var nombreCompleto: String = nombreCompleto
    var nombreUsuario: String = nombreUsuario
    var email: String = email
    var fechaNacimiento: LocalDate = fechaNacimiento
    var seguidores: List<Usuario> = emptyList()
    var seguidos: List<Usuario> = emptyList()

    fun calcularEdad(): Long {
        val fechaActual = LocalDate.now()
        return ChronoUnit.YEARS.between(fechaNacimiento, fechaActual)
    }

    fun tieneEmailDe(s: String): Boolean {
        var res = false
        val index = email.indexOf('@')
        val domain: String? = if (index == -1) null else email.substring(index + 1)
        if (domain != null) {
            res = domain.toUpperCase() == s.toUpperCase()
        }
        return res
    }

    fun obtenerInterseccionUsuariosSeguidoresYSeguidos(): Set<Usuario> {
        return seguidores.intersect(seguidos)
    }
}
