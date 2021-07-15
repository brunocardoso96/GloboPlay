package dominando.android.globoplay.ui.feature.moviedetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.databinding.FragmentMovieInfoBinding
import dominando.android.globoplay.helper.concatGenre

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieInfoBinding.inflate(layoutInflater)
        val root = binding.root
        return root
    }

    companion object {
        const val TITLE_DETAIL = "Detalhes"
    }

    fun setMovie(movie: MovieDetail){
        binding.txtOriginalTitle.text = movie.title
        binding.txtGenre.text = movie.genres.concatGenre()
        binding.txtLanguage.text = movie.languages
        binding.txtRuntime.text = movie.runtime.toString()
        binding.txtReleaseDate.text = movie.releaseDate
    }
}
