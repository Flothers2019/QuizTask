package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AdminActivity : AppCompatActivity() {
    lateinit var weltext : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        weltext = findViewById(R.id.adminWelcome)

        val adminUsername = intent.getStringExtra("adminUsername")
        if (adminUsername != null) {
            // Display the welcome message for the admin
            val welcomeMessage = "Welcome Admin: $adminUsername"
            weltext.text = welcomeMessage
        }
    }
}