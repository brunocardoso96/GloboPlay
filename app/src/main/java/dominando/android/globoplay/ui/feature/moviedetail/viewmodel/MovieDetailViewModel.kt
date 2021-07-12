package dominando.android.globoplay.ui.feature.moviedetail.viewmodel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.data.respository.MovieDetailRepository
import dominando.android.globoplay.ui.feature.moviedetail.fragment.DetailFragment
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val repository: MovieDetailRepository) : ViewModel(){

    val movieDetail = MutableLiveData<MovieDetail>()

    fun getMovieDetail(id: String) {
        viewModelScope.launch {
            DetailFragment.newInstance(repository.getMovieDetail(id))
            movieDetail.postValue(repository.getMovieDetail(id))
        }
    }

    class MovieDetailViewModelFactory(private val repository: MovieDetailRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MovieDetailViewModel(repository) as T
        }
    }
}