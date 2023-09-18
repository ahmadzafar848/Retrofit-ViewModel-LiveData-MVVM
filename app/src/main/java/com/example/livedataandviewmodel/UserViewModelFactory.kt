import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.livedataandviewmodel.UserViewModel
import com.example.livedataandviewmodel.UsersRepository

class UserViewModelFactory(private val usersRepository: UsersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(usersRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
