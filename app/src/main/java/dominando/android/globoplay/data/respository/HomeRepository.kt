package dominando.android.globoplay.data.respository

import dominando.android.globoplay.R
import dominando.android.globoplay.data.model.Genre
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieToGenre

class HomeRepository {

    val genres = getGenre()
    val movies = getMovie()
    val listMovieToGenre: MutableList<MovieToGenre> = ArrayList()

    fun getGenre(): List<Genre> {
        return listOf(
            Genre("1", "Comedia"),
            Genre("2", "Ação"),
            Genre("3", "Terror"),
            Genre("4", "Suspense"),
            Genre("5", "Romance"),
            Genre("6", "Desenho"),
        )
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

    fun getMovieToGenre(): List<MovieToGenre> {
        setMovieToGenre()
        return listMovieToGenre
    }

    private fun setMovieToGenre() {
        genres.forEach { genre ->
            listMovieToGenre.add(MovieToGenre(genre.id, genre.name, selectMovieToGenre(genres, movies, genre.id)))
        }
    }

    private fun selectMovieToGenre(genre: List<Genre>, movie: List<Movie>, id: String): MutableList<Movie> {
        val movies: MutableList<Movie> = ArrayList()
        genre.forEach { genre ->
            movie.forEach { movie ->
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