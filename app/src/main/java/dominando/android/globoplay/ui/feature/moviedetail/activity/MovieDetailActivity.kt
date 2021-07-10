package dominando.android.globoplay.ui.feature.moviedetail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.data.respository.HomeRepository
import dominando.android.globoplay.data.respository.MovieDetailRepository
import dominando.android.globoplay.databinding.ActivityMovieDetailBinding
import dominando.android.globoplay.ui.feature.home.viewmodel.HomeViewModel
import dominando.android.globoplay.ui.feature.moviedetail.adapter.MovieInfoAdapter
import dominando.android.globoplay.ui.feature.moviedetail.fragment.DetailFragment
import dominando.android.globoplay.ui.feature.moviedetail.fragment.MyFavoriteMovie
import dominando.android.globoplay.ui.feature.moviedetail.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.rv_home_list_genre.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieInfoAdapter(supportFragmentManager)
        adapter.addFragment(MyFavoriteMovie(), "Assista Também")
        adapter.addFragment(DetailFragment(), "Detalhes")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
        initialize()
    }

    private fun initialize() {
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            MovieDetailViewModel.
            MovieDetailViewModelFactory(MovieDetailRepository()))
            .get(MovieDetailViewModel::class.java)

        val id = intent.getStringExtra("EXTRA_ID")
        id?.let { viewModel.getMovieDetail(it) }
    }

    companion object {
        fun getIntentMovieDetail(context: Context): Intent {
            return Intent(context, MovieDetailActivity::class.java)
        }
    }
}