package dominando.android.globoplay.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.data.respository.HomeRepository
import dominando.android.globoplay.ui.adapter.HomeGenreAdapter
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerViewGenre: RecyclerView
    private val repository = HomeRepository()

    private val listMovieToGenre = repository.getMovieToGenre()

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
            recyclerViewGenre.adapter = HomeGenreAdapter(this@HomeActivity, listMovieToGenre )
        }
    }

    private fun viewBind() {
        recyclerViewGenre = findViewById(R.id.rvHomeGenre)
    }
}
