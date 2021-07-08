package dominando.android.globoplay.data.respository

import dominando.android.globoplay.R
import dominando.android.globoplay.data.model.Genre
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.data.network.Api
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class HomeRepository {

    private val movieByGenre = ArrayList<MovieToGenre>()
    private val service = Api.initRetrofit()

    suspend fun getGenre(): List<Genre> {
        return service.getGenre(Api.APIKEY)
            .genres
            .map {
                Genre(it.id.toString(), it.name)
            }
    }

    fun getMovie(): List<Movie> {
        return listOf(
                Movie("1", "Army Of Death", listOf("2"), R.drawable.sonic),
                Movie("2", "Romeu e Julieta", listOf("2", "5"), R.drawable.sonic),
                Movie("3", "E o fim", listOf("1", "4"), R.drawable.sonic),
                Movie("4", "Bumbeble", listOf("2", "5"), R.drawable.sonic),
                Movie("5", "Tropa de Elite", listOf("2", "1", "6"), R.drawable.sonic),
                Movie("6", "Cidade de Gelo", listOf("1", "5"), R.drawable.sonic),
                Movie("7", "O Protetor", listOf("2", "6"), R.drawable.sonic),
                Movie("8", "Baywatch", listOf("2", "3", "4"), R.drawable.sonic),
                Movie("9", "Perda Total", listOf("6"), R.drawable.sonic),
                Movie("10", "Zerando a Vida", listOf("5", "6"), R.drawable.sonic),
                Movie("11", "Rambo", listOf("1", "3"), R.drawable.sonic),
                Movie("12", "Amor e Monstros", listOf("4"), R.drawable.sonic),
                Movie("13", "Samurai X", listOf("1", "2", "3"), R.drawable.sonic)
        )
    }

    suspend fun getMovieByGenre(): ArrayList<MovieToGenre> {
        getGenre().forEach { genre ->
            movieByGenre.add(MovieToGenre(genre.id, genre.name, selectMovieToGenre(getGenre(), getMovie(), genre.id)))
        }
        return movieByGenre
    }

    private fun selectMovieToGenre(listGenre: List<Genre>, listMovie: List<Movie>, id: String): MutableList<Movie> {
        val movies: MutableList<Movie> = ArrayList()
        listGenre.forEach {
            listMovie.forEach { movie ->
                movie.genre.forEach {
                    val retorno = it.filter { it.toString() == id }
                    if (retorno == id) {
                        movies.add(Movie(movie.id, movie.name, movie.genre, movie.imageUrl))
                    }
                }
            }
            return movies
        }
        return movies
    }

}