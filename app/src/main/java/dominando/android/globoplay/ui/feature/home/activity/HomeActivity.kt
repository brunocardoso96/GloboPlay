package dominando.android.globoplay.ui.feature.home.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.data.respository.HomeRepository
import dominando.android.globoplay.databinding.ActivityMainBinding
import dominando.android.globoplay.ui.feature.home.adapter.HomeGenreAdapter
import dominando.android.globoplay.ui.feature.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerViewGenre: RecyclerView
    private lateinit var viewModel: HomeViewModel
    private val adapterGenre = HomeGenreAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        viewBind()
        setupViewModel()
        setupActionBar()
        setupRecyclerGenre()
        viewModel.getMovieByGenre()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }

    private fun setupRecyclerGenre() {
        recyclerViewGenre.run {
            layoutManager = LinearLayoutManager(this@HomeActivity, RecyclerView.VERTICAL, false)
            adapter = adapterGenre
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, HomeViewModel.HomeViewModelFactory(HomeRepository())).get(
            HomeViewModel::class.java)
        viewModel.movieByGenreLiveData.observe(this) {
            adapterGenre.addMovieToGenre(it)
        }
    }

    private fun viewBind() {
        recyclerViewGenre = binding.rvHomeGenre
    }
}
