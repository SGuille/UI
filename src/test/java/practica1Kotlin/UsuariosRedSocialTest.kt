package practica1Kotlin

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import practica1Kotlin.Ejercicio3.Usuario
import java.time.LocalDate
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class UsuariosRedSocialTest {

    val date = LocalDate.parse("1992-09-26")
    private val usuario: Usuario = Usuario("Guille Salvatore", "SGuille", "guillesalvatore@gmail.com", date)
    private val usuario2: Usuario = Usuario("Juan Perez", "juanp", "juanp@gmail.com", date)
    private val usuario3: Usuario = Usuario("Carlos Lopez", "CarlosL", "carlosl@hotmail.com", date)
    private val seguidoresDeUsuario = listOf(usuario2)
    private val seguidosPorUsuario = listOf(usuario3, usuario2)

    @Before
    fun setup() {
        this.usuario.seguidores = seguidoresDeUsuario
        this.usuario.seguidos = seguidosPorUsuario
    }


    @Test fun testParaObtenerLaInformacionBasicaDeUnUsuario() {

        assertEquals("Guille Salvatore", this.usuario.nombreCompleto)
        assertEquals("SGuille", this.usuario.nombreUsuario)
        assertEquals("guillesalvatore@gmail.com", this.usuario.email)
        assertEquals(date, this.usuario.fechaNacimiento)
        assertEquals(1, this.usuario.seguidores.count())
        assertEquals(2, this.usuario.seguidos.count())
    }

    @Test fun testCalcularEdad() {
        val edad = this.usuario.calcularEdad()
        assertEquals(26, edad)
    }

    @Test fun testDeterminarSiElEmailRegistradoEsDeGmail() {
        val esGmail = this.usuario.tieneEmailDe("gmail.com")
        assertTrue(esGmail)
    }

    @Test fun testAlObtenerLosUsuariosSeguidoresQueALaVezSonSeguidosPorUnUsuario() {
        val usuariosSeguidoresYSeguidos = this.usuario.obtenerInterseccionUsuariosSeguidoresYSeguidos()
        assertEquals(1, usuariosSeguidoresYSeguidos.count())
    }
}
