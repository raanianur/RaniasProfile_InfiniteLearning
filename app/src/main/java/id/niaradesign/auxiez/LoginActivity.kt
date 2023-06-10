package id.niaradesign.auxiez

/*import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLupaPassword: TextView
    private lateinit var btnLogin: Button
    private lateinit var btnLoginToRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_pwd)
        btnLupaPassword = findViewById(R.id.btn_lupapass)
        btnLogin = findViewById(R.id.btn_login)
        btnLoginToRegister = findViewById(R.id.btn_logintoregister)

        btnLupaPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        btnLoginToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}*/

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import id.niaradesign.auxiez.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLupaPassword: TextView
    private lateinit var btnLogin: Button
    private lateinit var btnLoginToRegister: Button
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_pwd)
        btnLupaPassword = findViewById(R.id.btn_lupapass)
        btnLogin = findViewById(R.id.btn_login)
        btnLoginToRegister = findViewById(R.id.btn_logintoregister)

        btnLupaPassword.setOnClickListener {
            val intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            val loginSuccess = viewModel.loginUser(email, password)

            if (loginSuccess) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        btnLoginToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}


