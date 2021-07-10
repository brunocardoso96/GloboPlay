package dominando.android.globoplay.data.respository

import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.data.network.Api

class MovieDetailRepository {

    private val service = Api.serviceMovieDetail()

    suspend fun getMovieDetail(id: String): MovieDetail {
        return service.getMovieDetail(id, Api.APIKEY).run {
            MovieDetail(title, genres, runtime, overview, releaseDate, originalLanguage, posterPath)
        }
    }
}