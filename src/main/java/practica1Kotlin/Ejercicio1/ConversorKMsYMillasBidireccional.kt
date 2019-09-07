package practica1Kotlin.Ejercicio1

import kotlin.math.roundToInt

class ConversorKMsYMillasBidireccional {
    fun convertirMillasAKMs(medidaMillas: Int): Double {
        return ((medidaMillas * 1.609344) * 1000.0).roundToInt() / 1000.0
    }

    fun convertirKMsAMillas(medidaKMs: Int): Double {
        return ((medidaKMs * 0.621371) * 1000.0).roundToInt() / 1000.0
    }

}
