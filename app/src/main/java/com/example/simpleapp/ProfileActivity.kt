package com.example.simpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    private var username: String? = null
    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = intent.getStringExtra("username")
        email = intent.getStringExtra("email")
        password = intent.getStringExtra("password")

        val tvProfileUsername = findViewById<TextView>(R.id.profile_username)
        val tvProfileEmail = findViewById<TextView>(R.id.profile_email)
        val tvProfilePassword = findViewById<TextView>(R.id.profile_password)
        val btnEditProfile = findViewById<Button>(R.id.btnEdit)
        val btnBackToLogin = findViewById<Button>(R.id.btnBack)

        tvProfileUsername.text = "Username: ${username ?: ""}"
        tvProfileEmail.text = "Email: ${email ?: ""}"
        tvProfilePassword.text = "Password: ${password ?: ""}"

        btnEditProfile.setOnClickListener {
            Toast.makeText(this, "Edit Profile Clicked", Toast.LENGTH_SHORT).show()
        }

        btnBackToLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }
}