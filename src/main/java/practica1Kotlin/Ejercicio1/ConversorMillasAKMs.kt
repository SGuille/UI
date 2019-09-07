package practica1Kotlin.Ejercicio1

import kotlin.math.roundToInt

class ConversorMillasAKMs {
    fun convertir(medidaMillas: Int): Double {
        return ((medidaMillas * 1.609344) * 1000.0).roundToInt() / 1000.0
    }

}
