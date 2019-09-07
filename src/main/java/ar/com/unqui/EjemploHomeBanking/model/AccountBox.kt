package ar.com.unqui.EjemploHomeBanking.model

import org.uqbar.commons.model.exceptions.UserException

class AccountBox : Account {
    constructor() : super()

    override fun extract(mount: Int): Int {
        if (this.available - mount >= 0) {
            this.available -= mount
        }else{
            throw UserException("No se puede extraer mas que el saldo disponible")
        }
        return this.available
    }

    override fun typeOfAccount(): String = "Caja de ahorro"
}
