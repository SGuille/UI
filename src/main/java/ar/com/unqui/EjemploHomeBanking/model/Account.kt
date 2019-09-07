package ar.com.unqui.EjemploHomeBanking.model

abstract class Account {

    var available = 0
    abstract fun extract(mount: Int) : Int
    abstract fun typeOfAccount(): String
}
