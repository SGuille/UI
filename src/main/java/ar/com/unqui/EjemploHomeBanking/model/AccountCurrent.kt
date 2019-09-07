package ar.com.unqui.EjemploHomeBanking.model

import org.uqbar.commons.model.exceptions.UserException

class AccountCurrent : Account {
    var discover = 0
    constructor() : super()

    override fun extract(mount: Int): Int {
        if (this.available + discover >= mount) {
            this.available -= mount
        }else{
            throw UserException("No se puede extraer un monto mayor al disponible y discover")
        }
        return this.available
    }

    override fun typeOfAccount(): String = "Cuenta Corriente"
}
