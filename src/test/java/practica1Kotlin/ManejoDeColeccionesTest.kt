package practica1Kotlin

import org.junit.Test
import practica1Kotlin.Ejercicio4.UIList
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ManejoDeColeccionesTest {

    private val uiList: UIList = UIList()
    private val numListAsc = listOf(1,2,3,4,5)
    private val numListDesc = listOf(5,4,3,2,1)
    private val numListDisordered = listOf(4,1,5,2,3)

    @Test fun testDadaUnaListaSaberSiEstaOrdenada() {
        val resAsc = this.uiList.isSorted(numListAsc)
        val resDesc = this.uiList.isSorted(numListDesc)
        val resDisordered = this.uiList.isSorted(numListDisordered)
        assertTrue(resAsc)
        assertTrue(resDesc)
        assertFalse(resDisordered)
    }

    @Test fun testOrdenarListaAscendenteODescendente() {
        val resAsc = this.uiList.sortList(numListDisordered, true)
        val resDesc = this.uiList.sortList(numListDisordered, false)

        assertEquals(numListAsc, resAsc)
        assertEquals(numListDesc, resDesc)
    }

    @Test fun testDadaListaNumericaObtenerSoloNumerosPrimos() {
        val primes = this.uiList.filterPrimes(numListDisordered)

        assertEquals(listOf(2,3,5), primes)
    }

    @Test fun testDadaUnaListaNumericaDevuelveLaListaPotenciadaA2() {
        val res = this.uiList.powMap(numListAsc)

        assertEquals(listOf(1,4,9,16,25), res)
    }

    @Test fun testDadaUnaListaNumericaDevuelveResultadoDeSumarCadaNumeroMultiplicadoPorSuPosicion() {
        val sumProdPos = this.uiList.sumProdPos(listOf(1, 1, 2, 3, 5, 8))

        assertEquals(94, sumProdPos)
    }
}
