package practica1Kotlin

import org.junit.Test
import practica1Kotlin.Ejercicio2.Str
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ManejoDeStringsTest {

    private val str: Str = Str()

    @Test fun testDadoUnStringLoRetornaAlReves() {
        val res = this.str.revert("interfaces")
        assertEquals("secafretni", res)
    }

    @Test fun testDadaUnaPalabraDeterminaSiEsCapicua() {
        val noPalindrome = this.str.isPalindrome("interfaces")
        val palindrome = this.str.isPalindrome("neuquen")
        assertTrue(palindrome)
        assertFalse(noPalindrome)

    }

    @Test fun testDadoUnStringRetornaLaCantidadDeVocalesQueTiene() {
        val res = this.str.vowels("Ácido clorhídrico")
        assertEquals(7, res)
    }

    @Test fun testCantidadDePalabrasQueContieneOracion() {
        val res = this.str.words("construcción de interfaces de usuario")
        assertEquals(5, res)
    }

    @Test fun testCantidadDeParrafosQueContieneTexto() {
        val res = this.str.paragraphAmount("Probando ando."
                + "cantidad de parrafos."
                + "en ésta cadena de texto.")
        assertEquals(2, res)
    }
}
