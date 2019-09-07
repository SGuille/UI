package ar.com.unqui.EjemploHomeBanking.desktop

import ar.com.unqui.EjemploHomeBanking.model.AccountBox
import ar.com.unqui.EjemploHomeBanking.model.AccountCurrent
import ar.com.unqui.EjemploHomeBanking.model.Bank
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window

class ApplicationCajero : Application() {

    override fun createMainWindow(): Window<*> {
        var account = AccountBox()
        account.available = 50
        var account3 = AccountCurrent()
        account3.available  = 50
        account3.discover = 5

        var bank = Bank()
        bank.accounts.add(account)
        bank.accounts.add(account3)

        return WindowCajero(this, bank)
    }
}

fun main() {
    ApplicationCajero().start()
}
