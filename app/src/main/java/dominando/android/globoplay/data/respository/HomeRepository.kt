package dominando.android.globoplay.data.respository

import dominando.android.globoplay.data.model.Genre
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.data.network.Api

class HomeRepository {

    private val movieByGenre = ArrayList<MovieToGenre>()
    private val service = Api.serviceMoviesDB()

    suspend fun getGenre(): List<Genre> {
        return service.getGenre(Api.APIKEY)
            .genres
            .map {
                Genre(it.id, it.name)
            }
    }

    suspend fun getMovie(): List<Movie> {
        return service.getMovie(Api.APIKEY)
            .results
            .map {
                Movie(it.id.toString(), it.title, it.genreIds, it.posterPath)
            }
    }

    suspend fun getMovieByGenre(): ArrayList<MovieToGenre> {
        getGenre().forEach { genre ->
            movieByGenre.add(MovieToGenre(genre.id, genre.name, selectMovieToGenre(getGenre(), getMovie(), genre.id)))
        }
        return movieByGenre
    }

    private fun selectMovieToGenre(listGenre: List<Genre>, listMovie: List<Movie>, id: Int): MutableList<Movie> {
        val movies: MutableList<Movie> = ArrayList()
        listGenre.forEach {
            listMovie.forEach { movie ->
                movie.genre.forEach {
                    if (it == id) {
                        movies.add(Movie(movie.id, movie.name, movie.genre, movie.image))
                    }
                }
            }
            return movies
        }
        return movies
    }
}