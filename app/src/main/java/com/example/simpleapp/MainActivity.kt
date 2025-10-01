package com.example.simpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<EditText>(R.id.username)
        val etPassword = findViewById<EditText>(R.id.password)
        val etEmail = findViewById<EditText>(R.id.email)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val email = etEmail.text.toString().trim()

            // Basic validation
            if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

            // Send Username and Email to Welcome Page
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("username", username)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }
}