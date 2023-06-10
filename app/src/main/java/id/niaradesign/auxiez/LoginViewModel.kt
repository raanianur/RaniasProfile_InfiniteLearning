package id.niaradesign.auxiez

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val userDatabase = UserDatabase

    fun loginUser(email: String, password: String): Boolean {
        val user = userDatabase.getUserByEmail(email)
        return user != null && user.password == password
    }
}