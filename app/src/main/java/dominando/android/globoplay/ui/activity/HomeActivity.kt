package dominando.android.globoplay.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.adapter.HomeGenreAdapter
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerViewGenre: RecyclerView
    private val listMovie = getMovie()
    private val listTopics = getTopics()
    private var mutableListGenre: MutableList<Genre> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        viewBind()
        setupActionBar()
        setupMovieToGenre()
        setupRecyclerGenre()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }

    private fun setupRecyclerGenre() {
        recyclerViewGenre.apply {
            recyclerViewGenre.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            recyclerViewGenre.adapter = HomeGenreAdapter(this@HomeActivity, mutableListGenre)
        }
    }

    private fun viewBind() {
        recyclerViewGenre = findViewById(R.id.rvHomeGenre)
    }

    fun setupMovieToGenre(){
        lateinit var listMovieToGenre: MutableList<Movie>
        listTopics.forEach { genre ->
            listMovie.forEach { movie ->
                movie.genre.forEach { idGenre ->
                    val movieFilter = idGenre.filter { idGenre == genre.id }
                    if(movieFilter == genre.id) listMovieToGenre.add(Movie(movie.id, movie.name, movie.genre, movie.imageUrl))
                }
            }
        mutableListGenre.add(Genre(genre.id, genre.name, listMovieToGenre))
        }
    }
}

class Genre(val id: String, val name: String, val movies: List<Movie>)

class Movie(val id: String, val name: String, val genre: List<String>, val imageUrl: Int)

class Topics(val id: String, val name: String)

fun getTopics(): List<Topics>{
    return listOf(
        Topics("1", "Comedia"),
        Topics("2", "Ação"),
        Topics("3", "Terror"),
        Topics("4", "Suspense"),
        Topics("5", "Romance"),
        Topics("6", "Desenho"),
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