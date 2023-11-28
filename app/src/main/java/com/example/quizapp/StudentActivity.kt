package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class StudentActivity : AppCompatActivity() {

    lateinit var welText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        welText = findViewById(R.id.studentWelcome)

        val studentId = intent.getIntExtra("studentId", -1)
        if (studentId != -1) {
            // Fetch student details using the studentId and display the welcome message
            val welcomeMessage = "Welcome Student with ID: $studentId"
            welText.text = welcomeMessage

        }
    }
}