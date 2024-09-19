package com.example.project5

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    companion object {
        const val EXTRA_NAME = "NAME"
        const val EXTRA_EMAIL = "EMAIL"
        const val EXTRA_PASSWORD = "PASSWORD"
        const val EXTRA_PHONE = "PHONE"
        const val EXTRA_GENDER = "GENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menampilkan keyboard secara otomatis pada
        // kolom nama saat activity dibuka
        showKeyboard()

        // Mengatur tombol register untuk menyimpan input pengguna
        binding.btnRegister.setOnClickListener {
            val name = binding.edtName.text.toString()
            val password = binding.edtPassword.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()
            val gender = binding.edtGender.text.toString()

            // Memeriksa apakah semua kolom diisi
            if (name.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()
                && phone.isNotEmpty() && gender.isNotEmpty()) {
                // Mengirim data ke LoginActivity
                val intentToLogin = Intent(this@RegisterActivity,
                    LoginActivity::class.java)
                intentToLogin.putExtra(EXTRA_NAME, name)
                intentToLogin.putExtra(EXTRA_PASSWORD, password)
                intentToLogin.putExtra(EXTRA_EMAIL, email)
                intentToLogin.putExtra(EXTRA_PHONE, phone)
                intentToLogin.putExtra(EXTRA_GENDER, gender)
                startActivity(intentToLogin)
                finish()
            } else {
                // Menampilkan pesan error jika ada kolom yang kosong
                Toast.makeText(this, "Mohon isi semua kolom!",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Fungsi untuk menampilkan keyboard saat activity dibuka
    private fun showKeyboard() {
        binding.edtName.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.edtName, InputMethodManager.SHOW_IMPLICIT)
    }
}
