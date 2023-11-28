package com.example.quizapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Student(
    @PrimaryKey val id: Int,
    val username: String,
    val password: String,
    val role: String = "student"

)


@Entity(tableName = "quiz_questions")
data class QuizQuestion(
    @PrimaryKey val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)


@Entity(tableName = "quiz_results")
data class QuizResult(
    @PrimaryKey val id: Int,
    val studentId: Int,
    val score: Int
)
