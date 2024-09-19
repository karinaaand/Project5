package com.example.project5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.project5.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    // Deklarasi variabel binding untuk menghubungkan
    // komponen XML dengan kode Kotlin
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding dengan inflating layout
        // dari activity_profile.xml
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengambil data (nama, email, nomor HP, jenis kelamin)
        // yang dikirim dari LoginActivity
        val name = intent.getStringExtra(LoginActivity.EXTRA_NAME)
        val email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL)
        val phone = intent.getStringExtra(LoginActivity.EXTRA_PHONE)
        val gender = intent.getStringExtra(LoginActivity.EXTRA_GENDER)

        // Menampilkan data yang diterima
        // di TextView masing-masing pada layout
        binding.txtName.text = "Nama: $name"
        binding.txtEmail.text = "Email: $email"
        binding.txtPhone.text = "Nomor HP: $phone"
        binding.txtGender.text = "Jenis Kelamin: $gender"
    }
}
