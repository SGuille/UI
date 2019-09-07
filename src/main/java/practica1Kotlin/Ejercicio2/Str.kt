package practica1Kotlin.Ejercicio2

class Str {
    fun revert(s: String): String {
        return s.reversed()
    }

    fun isPalindrome(s: String): Boolean {
        val sRevert = this.revert(s)
        return s == sRevert
    }

    fun vowels(s: String): Int {
        val cantTotal = s.count()
        val sinVocales = s.replace("[aeiouAEIOUáéíóúÁÉÍÓÚ]".toRegex(), "")
        val cantSinVocales = sinVocales.count()

        return cantTotal - cantSinVocales
    }

    fun words(s: String): Int {
        return s.split(" ").count()
    }

    fun paragraphAmount(s: String): Int {
        val res = s.split("\n")
        val countRes = res.count()
        return countRes
    }
}
