package id.niaradesign.auxiez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var btnRegisterToLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi view
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_pwd)
        btnRegister = findViewById(R.id.btn_register)
        btnRegisterToLogin = findViewById(R.id.btn_registertologin)

        // Set onClickListener untuk tombol Daftar
        btnRegister.setOnClickListener {
            // Implementasikan logika untuk melakukan proses registrasi di sini
            registerUser()
        }

        // Set onClickListener untuk tombol Sudah memiliki akun ? MASUK
        btnRegisterToLogin.setOnClickListener {
            // Pindah ke LoginActivity ketika tombol ditekan
            navigateToLogin()
        }
    }

    private fun registerUser() {
        // Mendapatkan nilai dari input email dan password
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        // Implementasikan logika untuk melakukan proses registrasi pengguna di sini
        val user = User(email, password)
        UserDatabase.addUser(user)

        // Setelah proses registrasi selesai, Anda dapat melanjutkan ke halaman lain, misalnya MainActivity
        // Misalnya:
        navigateToLoginActivity()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Menutup activity saat ini agar tidak bisa kembali ke RegisterActivity melalui tombol Back
    }

    private fun navigateToLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Menutup activity saat ini agar tidak bisa kembali ke RegisterActivity melalui tombol Back
    }
}
