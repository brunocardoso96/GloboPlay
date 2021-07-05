package dominando.android.globoplay.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.adapter.HomeGenreAdapter

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerViewGenre: RecyclerView
    private val listGenre = getGenre()
    private val listMovie = getMovie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        viewBind()
        setupActionBar()
        setupRecyclerGenre()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }

    private fun setupRecyclerGenre() {
        recyclerViewGenre.apply {
            recyclerViewGenre.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            recyclerViewGenre.adapter = HomeGenreAdapter(listGenre)
        }
    }

    private fun viewBind() {
        recyclerViewGenre = findViewById(R.id.rvHomeGenre)
    }



}

class Genre(val id: String, val name: String)

class Movie(val id: String, val name: String, val genre: List<String>)

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
        Movie("1", "Army Of Death", listOf("2")),
        Movie("2", "Romeu e Julieta", listOf("2", "5")),
        Movie("3", "E o fim", listOf("1", "4")),
        Movie("4", "Bumbeble", listOf("2", "5")),
        Movie("5", "Tropa de Elite", listOf("2", "1", "6")),
        Movie("6", "Cidade de Gelo", listOf("1", "5")),
        Movie("7", "O Protetor", listOf("2", "6")),
        Movie("8", "Baywatch", listOf("2", "3", "4")),
        Movie("9", "Perda Total", listOf("6")),
        Movie("10", "Zerando a Vida", listOf("5", "6")),
        Movie("11", "Rambo", listOf("1", "3")),
        Movie("12", "Amor e Monstros", listOf("4")),
        Movie("13", "Samurai X", listOf("1", "2", "3"))
    )
}