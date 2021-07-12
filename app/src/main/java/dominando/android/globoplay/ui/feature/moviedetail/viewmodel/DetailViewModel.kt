package dominando.android.globoplay.ui.feature.moviedetail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.helper.Resource

class DetailViewModel : ViewModel() {

    val movieLiveData = MutableLiveData<Resource<MovieDetail>>()

    fun getMovieDetail(movieDetail: MovieDetail) {
        movieLiveData.postValue(Resource.success(movieDetail))
    }

}