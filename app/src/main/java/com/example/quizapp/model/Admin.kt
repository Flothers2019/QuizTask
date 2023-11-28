package com.example.quizapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "admin")
data class Admin(
    @PrimaryKey val id: Int,
    val username: String,
    val password: String,
    val role: String = "admin"

    )