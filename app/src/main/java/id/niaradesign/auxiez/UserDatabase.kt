package id.niaradesign.auxiez

object UserDatabase {
    private val users = mutableListOf(
        User("rania020@example.com", "ranianur020"),
        User("rania021@example.com", "ranianur021"),
        User("rania022@example.com", "ranianur022")
    )

    fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    fun addUser(user: User) {
        users.add(user)
    }
}

data class User(val email: String, val password: String)