package dominando.android.globoplay.ui.feature.moviedetail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.data.respository.MovieDetailRepository
import dominando.android.globoplay.databinding.ActivityMovieDetailBinding
import dominando.android.globoplay.helper.concatGenre
import dominando.android.globoplay.helper.loadImage
import dominando.android.globoplay.ui.feature.moviedetail.adapter.MovieInfoAdapter
import dominando.android.globoplay.ui.feature.moviedetail.fragment.DetailFragment
import dominando.android.globoplay.ui.feature.moviedetail.fragment.MyFavoriteMovieFragment
import dominando.android.globoplay.ui.feature.moviedetail.viewmodel.MovieDetailViewModel
import kotlinx.android.synthetic.main.rv_home_list_genre.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
    }

    private fun initialize() {
        setupPageView()
        setupViewModel()

    }

    private fun setupPageView() {
        val adapter = MovieInfoAdapter(supportFragmentManager)
        adapter.addFragment(MyFavoriteMovieFragment(), MyFavoriteMovieFragment.TITLE_MY_FAVORITE)
        adapter.addFragment(DetailFragment(), DetailFragment.TITLE_DETAIL)
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            MovieDetailViewModel.
            MovieDetailViewModelFactory(MovieDetailRepository()))
            .get(MovieDetailViewModel::class.java)

        viewModel.movieDetail.observe(this) {
            binding.txtTitle.text = it.title
            binding.txtDescription.text = it.overview
            binding.txtGenre.text = it.genres.concatGenre()
            binding.imgBlur.loadImage(it.postPath)
            binding.imgMovie.loadImage(it.postPath)
            sendMovieDetail(it)
        }
    }

    private fun sendMovieDetail(movieDetail: MovieDetail) {
//        DetailFragment.newInstance()
    }

    companion object {
        const val EXTRA_ID = "EXTRA_ID"
        fun getIntentMovieDetail(context: Context): Intent {
            return Intent(context, MovieDetailActivity::class.java)
        }
    }
}