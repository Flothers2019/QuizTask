package com.example.quizapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.model.QuizQuestion
import com.example.quizapp.model.QuizResult
import com.example.quizapp.model.Student

@Dao
interface StudentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("SELECT * FROM students WHERE username = :username AND password = :password")
    fun login(username: String, password: String): Student?
}

@Dao
interface QuizQuestionDao {
    @Query("SELECT * FROM quiz_questions")
    fun getAllQuestions(): List<QuizQuestion>

    // Add other queries for CRUD operations on QuizQuestion entity
}

@Dao
interface QuizResultDao {
    @Query("SELECT * FROM quiz_results WHERE studentId = :studentId")
    fun getResultsForStudent(studentId: Int): List<QuizResult>

    @Insert
    fun insert(quizResult: QuizResult)

    @Query("SELECT * FROM quiz_results")
    fun getAllQuizResults(): List<QuizResult>

}