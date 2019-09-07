package ar.com.unqui.EjemploHomeBanking.desktop

import ar.com.unqui.EjemploHomeBanking.model.Account
import ar.com.unqui.EjemploHomeBanking.model.Bank
import org.eclipse.swt.widgets.Table
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.widgets.tables.Column
import org.uqbar.arena.windows.WindowOwner

class WindowCajero : SimpleWindow<Bank> {
    constructor(owner: WindowOwner, model: Bank) : super(owner, model)

    override fun addActions(actionsPanel: Panel?) {

    }

    override fun createFormPanel(mainPanel: Panel?) {
        title = "Cajero automatico"
        Label(mainPanel) with {
            text = "Seleccione la cuenta con la que desea operar"
        }
//        Table(mainPanel, Account::class.java) with {
//            it bindItemsTo "account"
//            it bindSelectionTo = "selectAccount"
//            Column(it) with {
//                title = "Tipo de cuenta"
//                it bindContentsToProperty("typeOfAccount")
//            }
//            Column(it) with {
//                title = "Saldo"
//                it bindContentsToProperty("available")
//            }
//            Label(mainPanel) with {
//                text = "Ingrese el valor que desea extraer"
//            }
//            TextBox(mainPanel) with {
//
//            }
//            Button(mainPanel) with {
//                caption = "Extreaer"
//                onClick({ openDialog() })
//            }
//        }

    }
}
