package dominando.android.globoplay.data.network

import dominando.android.globoplay.data.response.GenreResponse
import dominando.android.globoplay.data.response.MovieDetailResponse
import dominando.android.globoplay.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {

    @GET("genre/movie/list")
    suspend fun getGenre(@Query("api_key") apiKey: String): GenreResponse

    @GET("movie/popular")
    suspend fun getMovie(@Query("api_key") apiKey: String): MovieResponse

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: String,
                               @Query("api_key") apiKey: String
    ): MovieDetailResponse
}