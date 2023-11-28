package com.example.quizapp

import com.example.quizapp.database.AdminDao
import com.example.quizapp.database.QuizQuestionDao
import com.example.quizapp.database.QuizResultDao
import com.example.quizapp.database.StudentDao
import com.example.quizapp.model.Admin
import com.example.quizapp.model.QuizQuestion
import com.example.quizapp.model.QuizResult
import com.example.quizapp.model.Student

class Repository(
    private val studentDao: StudentDao,
    private val quizQuestionDao: QuizQuestionDao,
    private val quizResultDao: QuizResultDao,
    private val adminDao: AdminDao
) {

    fun loginAsStudent(username: String, password: String): Student? {
        return studentDao.login(username, password)
    }

    fun loginAsAdmin(username: String, password: String): Admin? {
        return adminDao.login(username, password)
    }

    suspend fun signUpAsStudent(username: String, password: String) {
        val student = Student(id = 0, username = username, password = password)
        studentDao.insert(student)
    }

    suspend fun signUpAsAdmin(username: String, password: String) {
        val admin = Admin(id = 0, username = username, password = password)
        adminDao.insert(admin)
    }

    fun getQuizQuestions(): List<QuizQuestion> {
        return quizQuestionDao.getAllQuestions()
    }

    fun saveQuizResult(quizResult: QuizResult) {
        quizResultDao.insert(quizResult)
    }

    fun getQuizResults(): List<QuizResult> {
        return quizResultDao.getAllQuizResults()
    }
}