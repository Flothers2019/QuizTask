package com.example.quizapp.database

//import Converters
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quizapp.model.Admin
import com.example.quizapp.model.QuizQuestion
import com.example.quizapp.model.QuizResult
import com.example.quizapp.model.Student

@Database(entities = [Student::class, QuizQuestion::class, QuizResult::class, Admin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao
    abstract fun quizQuestionDao(): QuizQuestionDao
    abstract fun quizResultDao(): QuizResultDao
    abstract fun adminDao(): AdminDao
}
