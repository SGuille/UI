package ar.com.unqui.Practica3

import wallet.User

class UserWrapper {
    var usuario: String = ""
    var password: String = ""
    constructor(user: User) {
        this.usuario = user.email
        this.password = user.password
    }
}
