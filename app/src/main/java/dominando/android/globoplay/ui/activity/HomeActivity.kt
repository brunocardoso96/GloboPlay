package dominando.android.globoplay.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.data.respository.HomeRepository
import dominando.android.globoplay.ui.adapter.HomeGenreAdapter
import dominando.android.globoplay.ui.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.rv_home_list_genre.*
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerViewGenre: RecyclerView
    private lateinit var viewModel: HomeViewModel
    private var listMovieToGenre: MutableList<MovieToGenre> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
    }

    private fun initialize() {
        viewBind()
        setupViewModel()
        setupActionBar()
        setupRecyclerGenre()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }

    private fun setupRecyclerGenre() {
        recyclerViewGenre.apply {
            recyclerViewGenre.layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            recyclerViewGenre.adapter = HomeGenreAdapter(this@HomeActivity, listMovieToGenre)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, HomeViewModel.HomeViewModelFactory(HomeRepository())).get(HomeViewModel::class.java)
        viewModel.getMovieByGenre()
        viewModel.movieByGenreLiveData.observe(this) {
            it.forEach { movieToGenre ->
                listMovieToGenre.add(movieToGenre)
            }
        }
    }

    private fun viewBind() {
        recyclerViewGenre = findViewById(R.id.rvHomeGenre)
    }
}
