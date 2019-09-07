package practica1Kotlin.Ejercicio1

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class ConversorKMsAMillas {
    fun convertir(medidaKMs: Int): Double {
        return ((medidaKMs * 0.621371) * 1000.0).roundToInt() / 1000.0
    }

}
