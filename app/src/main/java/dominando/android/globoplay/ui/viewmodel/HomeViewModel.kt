package dominando.android.globoplay.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.data.respository.HomeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val movieByGenreLiveData = MutableLiveData<List<MovieToGenre>>()

    fun getMovieByGenre() {
//        movieByGenreLiveData.postValue(repository.getMovieByGenre())
        viewModelScope.launch {
            try {
                val result = repository.getGenre()
                Log.e("ResultGenre", result.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    class HomeViewModelFactory(private val repository: HomeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(repository) as T
        }
    }
}