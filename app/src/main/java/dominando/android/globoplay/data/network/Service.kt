package dominando.android.globoplay.data.network

import dominando.android.globoplay.data.response.GenreResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("genre/movie/list")
    suspend fun getGenre(@Query("api_key") apiKey: String): GenreResponse
}