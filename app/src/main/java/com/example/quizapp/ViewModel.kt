import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizapp.Repository
import com.example.quizapp.model.QuizQuestion
import com.example.quizapp.model.QuizResult
import kotlinx.coroutines.launch

class QuizViewModel(private val repository: Repository) : ViewModel() {

    // LiveData to observe quiz questions
    private val _quizQuestions = MutableLiveData<List<QuizQuestion>>()
    val quizQuestions: LiveData<List<QuizQuestion>> get() = _quizQuestions

    // LiveData to observe quiz results
    private val _quizResults = MutableLiveData<List<QuizResult>>()
    val quizResults: LiveData<List<QuizResult>> get() = _quizResults

    // Function to load quiz questions
    fun loadQuizQuestions() {
        viewModelScope.launch {
            val questions = repository.getQuizQuestions()
            _quizQuestions.value = questions
        }
    }

    // Function to save quiz result
    fun saveQuizResult(quizResult: QuizResult) {
        viewModelScope.launch {
            repository.saveQuizResult(quizResult)
        }
    }

    // Function to load quiz results
    fun loadQuizResults() {
        viewModelScope.launch {
            val results = repository.getQuizResults()
            _quizResults.value = results
        }
    }


    // Additional functions related to quizzes can be added here

    // For example, a function to start a new quiz
    fun startNewQuiz() {
        // Implement logic to start a new quiz
    }

    // For example, a function to end the current quiz
    fun endQuiz() {
        // Implement logic to end the current quiz
    }
}