package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginUserName: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        // Initialize views
        loginUserName = findViewById(R.id.loginUserName)
        loginPassword = findViewById(R.id.loginPassword)
        loginButton = findViewById(R.id.loginButton)

        // Initialize repository (you should inject this dependency using Dagger or Koin)
//        repository = Repository(/* pass necessary dependencies */)

        // Set click listener for login button
        loginButton.setOnClickListener {
            performLogin()
        }
    }
    private fun performLogin() {
        val username = loginUserName.text.toString()
        val password = loginPassword.text.toString()

        // Check if the entered credentials are valid for a student
        val student = repository.loginAsStudent(username, password)

        // Check if the entered credentials are valid for an admin
        val admin = repository.loginAsAdmin(username, password)

        if (student != null) {
            // Successfully logged in as student, navigate to student activity
            // You can pass the student ID or other relevant data to the next activity
            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("studentId", student.username)
            startActivity(intent)
            finish()
        } else if (admin != null) {
            // Successfully logged in as admin, navigate to admin activity
            startActivity(Intent(this, AdminActivity::class.java))
            intent.putExtra("adminUsername", admin.username)
            startActivity(intent)
            finish()
        } else {
            // Invalid credentials, show an error message
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
    }
    }

