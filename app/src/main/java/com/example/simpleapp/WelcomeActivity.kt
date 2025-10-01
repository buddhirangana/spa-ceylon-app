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

class WelcomeActivity : AppCompatActivity() {

    private var username: String? = null
    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.welcome)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = intent.getStringExtra("username")
        email = intent.getStringExtra("email")
        password = intent.getStringExtra("password")

        val tvWelcome = findViewById<TextView>(R.id.message)
        val tvEmail = findViewById<TextView>(R.id.email)
        val btnProfile = findViewById<Button>(R.id.btnProfile)

        tvWelcome.text = "Welcome, ${username ?: "User"}"
        tvEmail.text = "Email: ${email ?: ""}"

        btnProfile.setOnClickListener {
            Toast.makeText(this, "You are on Profile Page", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }
}