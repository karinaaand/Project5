package com.example.project5

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project5.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    companion object {
        const val EXTRA_NAME = "EXTRA_NAME"
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
        const val EXTRA_PHONE = "EXTRA_PHONE"
        const val EXTRA_GENDER = "EXTRA_GENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data yang dikirim dari RegisterActivity
        val name = intent.getStringExtra(RegisterActivity.EXTRA_NAME)
        val password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD)
        val email = intent.getStringExtra(RegisterActivity.EXTRA_EMAIL)
        val phone = intent.getStringExtra(RegisterActivity.EXTRA_PHONE)
        val gender = intent.getStringExtra(RegisterActivity.EXTRA_GENDER)

        // Menampilkan nama dan password dalam Toast untuk debugging
        Toast.makeText(this, "NAMA = $name, " +
                "PASSWORD = $password", Toast.LENGTH_LONG).show()

        // Mengatur tombol login untuk memeriksa kredensial pengguna
        binding.btnLogin.setOnClickListener {
            val inputEmail = binding.edtEmail.text.toString()
            val inputPassword = binding.edtPassword.text.toString()

            // Memeriksa apakah email dan password diisi
            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                // Memeriksa apakah email dan password cocok dengan
                // yang diterima dari RegisterActivity
                if (inputEmail == email && inputPassword == password) {
                    // Jika cocok, berpindah ke ProfileActivity
                    val intent = Intent(this,
                        ProfileActivity::class.java)
                    intent.putExtra(EXTRA_NAME, name)
                    intent.putExtra(EXTRA_EMAIL, email)
                    intent.putExtra(EXTRA_PHONE, phone)
                    intent.putExtra(EXTRA_GENDER, gender)
                    startActivity(intent)
                    finish()
                } else {
                    // Menampilkan pesan jika email atau password salah
                    Toast.makeText(this, "Email atau Password salah!",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                // Menampilkan pesan jika kolom email atau password kosong
                Toast.makeText(this, "Mohon isi semua kolom!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
