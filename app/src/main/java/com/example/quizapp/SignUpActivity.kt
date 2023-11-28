package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var roleSpinner: Spinner
    private lateinit var signUpButton: Button

    private lateinit var repository: Repository
    private lateinit var  viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        roleSpinner = findViewById(R.id.roleSpinner)
        signUpButton = findViewById(R.id.signUpButton)


//        repository = Repository()

        signUpButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val selectedRole = roleSpinner.selectedItem.toString()

            when (selectedRole) {
                "Student" -> viewModel.signUpAsStudent(username, password)
                "Admin" -> viewModel.signUpAsAdmin(username, password)
            }
        }
    }

    class SignUpViewModel(private val repository: Repository) : ViewModel() {

        fun signUpAsStudent(username: String, password: String) {
            viewModelScope.launch {
                try {
                    repository.signUpAsStudent(username, password)

                } catch (e: Exception) {

                }
            }
        }

        fun signUpAsAdmin(username: String, password: String) {
            viewModelScope.launch {
                try {
                    repository.signUpAsAdmin(username, password)

                } catch (e: Exception) {

                }
            }
        }
    }
}