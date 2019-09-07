package ar.com.unqui.EjemploHomeBanking.model

import org.uqbar.commons.model.annotations.Observable

@Observable
class Bank {
    var accounts : MutableList<Account> = mutableListOf();
    var selectAccount : Account? = null
    var input: Int = 0


}
