package dominando.android.globoplay.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.data.respository.HomeRepository

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    val movieByGenreLiveData = MutableLiveData<List<MovieToGenre>>()

    val listMovieToGenre: MutableList<MovieToGenre> = ArrayList()

    fun getMovieByGenre(){
        repository.getMovieByGenre().forEach {
            listMovieToGenre.add(it)
        }
        movieByGenreLiveData.value = listMovieToGenre
    }

    class HomeViewModelFactory(private val repository: HomeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(repository) as T
        }
    }
}