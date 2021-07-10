package dominando.android.globoplay.ui.feature.moviedetail.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.data.respository.HomeRepository
import dominando.android.globoplay.data.respository.MovieDetailRepository
import dominando.android.globoplay.ui.feature.home.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieDetailViewModel(private val repository: MovieDetailRepository) : ViewModel(){

    val movieDetail = MutableLiveData<MovieDetail>()

    fun getMovieDetail(id: String) {
        viewModelScope.launch {
            try {
                val result = repository.getMovieDetail(id)
                Log.e("ResultGenre", result.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    class MovieDetailViewModelFactory(private val repository: MovieDetailRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieDetailViewModel(repository) as T
        }
    }
}