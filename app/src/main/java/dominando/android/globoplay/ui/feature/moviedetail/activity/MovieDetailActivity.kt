package dominando.android.globoplay.ui.feature.moviedetail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dominando.android.globoplay.databinding.ActivityMovieDetailBinding
import dominando.android.globoplay.ui.feature.moviedetail.adapter.MovieInfoAdapter
import dominando.android.globoplay.ui.feature.moviedetail.fragment.MovieInfoFragment
import dominando.android.globoplay.ui.feature.moviedetail.fragment.MyFavoriteMovie

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MovieInfoAdapter(supportFragmentManager)
        adapter.addFragment(MyFavoriteMovie(), "Assista Também")
        adapter.addFragment(MovieInfoFragment(), "Detalhes")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    companion object {
        fun getIntentMovieDetail(context: Context): Intent {
            return Intent(context, MovieDetailActivity::class.java)
        }
    }
}