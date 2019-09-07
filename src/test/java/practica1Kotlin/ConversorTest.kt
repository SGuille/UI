package practica1Kotlin

import junit.framework.TestCase.assertEquals
import org.junit.Test
import practica1Kotlin.Ejercicio1.ConversorGenerico
import practica1Kotlin.Ejercicio1.ConversorKMsAMillas
import practica1Kotlin.Ejercicio1.ConversorKMsYMillasBidireccional
import practica1Kotlin.Ejercicio1.ConversorMillasAKMs

class ConversorTest {

    private var conversorGenerico: ConversorGenerico = ConversorGenerico()
    private var conversorKMsYMillasBidireccional: ConversorKMsYMillasBidireccional = ConversorKMsYMillasBidireccional()
    private var conversorKMsAMillas: ConversorKMsAMillas = ConversorKMsAMillas()
    private var conversorMillasAKMs: ConversorMillasAKMs = ConversorMillasAKMs()

    @Test fun testConvertirMillasAKMs() {
        val medidaMillas = 1
        val res = this.conversorMillasAKMs.convertir(medidaMillas)
        assertEquals(1.609,  res)
    }

    @Test fun testConvertirKMsAMillas() {
        val medidaKMs = 100
        val res = conversorKMsAMillas.convertir(medidaKMs)
        assertEquals(62.137, res)
    }

    @Test fun testConvertirKMsYMillasBidireccionalmente() {
        val medidaMillas = 1
        val resMillas = conversorKMsYMillasBidireccional.convertirMillasAKMs(medidaMillas)
        assertEquals(1.609, resMillas)

        val medidaKMs = 100
        val resKMs = conversorKMsYMillasBidireccional.convertirKMsAMillas(medidaKMs)
        assertEquals(62.137, resKMs)
    }

    @Test fun testConvertirCualquierUnidadDeMedida() {
        val medidaMillas = 10
        val medidaKMs = 100
        val medidaMetros = 1000
        val medidaCentimetros = 10000

        conversorGenerico.convertir(medidaMillas, "Milla", "KM")
        assertEquals(100, medidaKMs)

        conversorGenerico.convertir(medidaKMs, "KM", "Metro")
        assertEquals(1000, medidaMetros)

        conversorGenerico.convertir(medidaMetros, "Metro", "Centimetro")
        assertEquals(10000, medidaCentimetros)

        conversorGenerico.convertir(medidaCentimetros, "Centimetro", "Metro")
        assertEquals(1000, medidaMetros)

        conversorGenerico.convertir(medidaMetros, "Metro", "KM")
        assertEquals(100, medidaKMs)

        conversorGenerico.convertir(medidaKMs, "KM", "Milla")
        assertEquals(10, medidaMillas)
    }
}
