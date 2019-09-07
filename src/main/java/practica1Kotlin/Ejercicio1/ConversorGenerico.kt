package practica1Kotlin.Ejercicio1

import kotlin.math.roundToInt

class ConversorGenerico {
    fun convertir(unidadDeMedida: Int, tipoConversion: String, tipoConversionDeseada: String): Double {
        var res = 0.0

        when (tipoConversionDeseada) {
            "KM" -> res = this.convertirAKMs(tipoConversion, unidadDeMedida)
            "Milla" -> res = this.convertirAMilla(tipoConversion, unidadDeMedida)
            "Metro" -> res = this.convertirAMetro(tipoConversion, unidadDeMedida)
            "Centimetro" -> res = this.convertirACentimetro(tipoConversion,unidadDeMedida)
            else -> println("No se puede convertir a esa unidad de medida.")
        }

        return res
    }

    private fun convertirACentimetro(tipoConversion: String, unidadDeMedida: Int): Double {
        var res = 0.0

        when (tipoConversion) {
            "KM" -> res = this.convertirKMsACentimetros(unidadDeMedida)
            "Milla" -> res = this.convertirMillasACentimetros(unidadDeMedida)
            "Metro" -> res = this.convertirMetrosACentimetros(unidadDeMedida)
            else -> println("No se puede convertir esa unidad de medida")
        }

        return res
    }

    private fun convertirMillasACentimetros(unidadDeMedida: Int): Double {
        val MillasAKMs = this.convertirMillasAKMs(unidadDeMedida)
        val KMsAMetros = this.convertirKMsAMetros(MillasAKMs.toInt())
        return this.convertirMetrosACentimetros(KMsAMetros.toInt())
    }

    private fun convertirKMsACentimetros(unidadDeMedida: Int): Double {
        val KMsAMetros = this.convertirKMsAMetros(unidadDeMedida)
        return this.convertirMetrosACentimetros(KMsAMetros.toInt())
    }

    private fun convertirMetrosACentimetros(unidadDeMedida: Int): Double {
        return ((unidadDeMedida * 100 ) * 1000.0).roundToInt() / 1000.0 // m / 0.010000
    }

    private fun convertirAMetro(tipoConversion: String, unidadDeMedida: Int): Double {
        var res = 0.0

        when (tipoConversion) {
            "KM" -> res = this.convertirKMsAMetros(unidadDeMedida)
            "Milla" -> res = this.convertirMillasAMetros(unidadDeMedida)
            "Centimetro" -> res = this.convertirCentimetrosAMetros(unidadDeMedida)
            else -> println("No se puede convertir esa unidad de medida")
        }

        return res
    }

    private fun convertirMillasAMetros(unidadDeMedida: Int): Double {
        val millasAKMs = this.convertirMillasAKMs(unidadDeMedida)
        return this.convertirKMsAMetros(millasAKMs.toInt())
    }

    private fun convertirKMsAMetros(unidadDeMedida: Int): Double {
        return ((unidadDeMedida / 0.0010000 ) * 1000.0).roundToInt() / 1000.0 // km * 1000
    }

    private fun convertirCentimetrosAMetros(unidadDeMedida: Int): Double {
        return ((unidadDeMedida / 100 ) * 1000.0).roundToInt() / 1000.0
    }

    private fun convertirAMilla(tipoConversion: String, unidadDeMedida: Int): Double {
        var res = 0.0

        when (tipoConversion) {
            "KM" -> res = this.convertirKMsAMillas(unidadDeMedida)
            "Metro" -> res = this.convertirMetrosAMillas(unidadDeMedida)
            "Centimetro" -> res = this.convertirCentimetrosAMillas(unidadDeMedida)
            else -> println("No se puede convertir esa unidad de medida")
        }

        return res
    }

    private fun convertirCentimetrosAMillas(unidadDeMedida: Int): Double {
        val centimetrosAMetros = this.convertirCentimetrosAMetros(unidadDeMedida)
        val metrosAKMs = this.convertirMetrosAKMs(centimetrosAMetros.toInt())

        return this.convertirKMsAMillas(metrosAKMs.toInt())
    }

    private fun convertirMetrosAMillas(unidadDeMedida: Int): Double {
        return ((unidadDeMedida / 1609.34) * 1000.0).roundToInt() / 1000.0 // metros * 0.00062137
    }

    private fun convertirKMsAMillas(unidadDeMedida: Int): Double {
        return ((unidadDeMedida * 0.621371) * 1000.0).roundToInt() / 1000.0
    }

    private fun convertirAKMs(tipoConversion: String, unidadDeMedida: Int): Double {
        var res = 0.0

        when (tipoConversion) {
            "Milla" -> res = this.convertirMillasAKMs(unidadDeMedida)
            "Metro" -> res = this.convertirMetrosAKMs(unidadDeMedida)
            "Centimetro" -> res = this.convertirCentimetrosAKMs(unidadDeMedida)
            else -> println("No se puede convertir esa unidad de medida")
        }

        return res
    }

    private fun convertirCentimetrosAKMs(unidadDeMedida: Int): Double {
        return ((unidadDeMedida / 100000) * 1000.0).roundToInt() / 1000.0
    }

    private fun convertirMetrosAKMs(unidadDeMedida: Int): Double {
        return ((unidadDeMedida / 1000) * 1000.0).roundToInt() / 1000.0
    }

    private fun convertirMillasAKMs(unidadDeMedida: Int): Double {
        return ((unidadDeMedida * 1.609344) * 1000.0).roundToInt() / 1000.0
    }

}
