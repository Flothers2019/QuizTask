package com.example.quizapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.model.Admin


@Dao
interface AdminDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(admin: Admin): Long

    @Query("SELECT * FROM admin WHERE username = :username AND password = :password")
    fun login(username: String, password: String): Admin?
}

