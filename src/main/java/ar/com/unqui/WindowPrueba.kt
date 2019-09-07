package ar.com.unqui

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.WindowOwner

class WindowPrueba : SimpleWindow<PruebaModelo> {

    constructor(owner: WindowOwner, model: PruebaModelo) : super(owner, model)

    override fun addActions(actionsPanel: Panel?) {
    }

    override fun createFormPanel(mainPanel: Panel?) {
        title = "Soy una ventana"
        Label (mainPanel) with {
            bindTo("message")
        }

        TextBox(mainPanel) with {
            bindTo("message")
        }
    }

}
