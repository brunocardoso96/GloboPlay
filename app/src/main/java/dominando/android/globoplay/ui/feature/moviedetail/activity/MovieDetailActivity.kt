package dominando.android.globoplay.ui.feature.moviedetail.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dominando.android.globoplay.databinding.ActivityMovieDetailBinding
import dominando.android.globoplay.ui.feature.moviedetail.adapter.MovieInfoAdapter

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = MovieInfoAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    companion object {
        fun getIntentMovieDetail(context: Context): Intent {
            return Intent(context, MovieDetailActivity::class.java)
        }
    }
}