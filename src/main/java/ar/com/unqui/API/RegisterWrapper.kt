package ar.com.unqui.API

import wallet.User

class RegisterWrapper(val password: String, val email: String, val idCard: String, val firstName: String, val lastName: String) {
    fun toUser() = User(idCard, firstName, lastName, email, password,false)
}
