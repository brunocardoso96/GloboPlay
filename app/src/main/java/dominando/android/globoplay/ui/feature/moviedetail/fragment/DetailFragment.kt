package dominando.android.globoplay.ui.feature.moviedetail.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.databinding.FragmentMovieInfoBinding
import dominando.android.globoplay.ui.feature.moviedetail.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentMovieInfoBinding? = null

    private val binding get() = _binding!!

    private lateinit var movie: MovieDetail

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieInfoBinding.inflate(layoutInflater)
        val root = binding.root
        return root
    }

    private fun initialize() {

    }

    companion object {
        const val TITLE_DETAIL = "Detalhes"
        const val EXTRA_TITLE_MOVIE = "EXTRA_TITLE_MOVIE"
        fun newInstance(movieDetail: MovieDetail?): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                   putSerializable(EXTRA_TITLE_MOVIE, movieDetail)
                    movie = getSerializable(EXTRA_TITLE_MOVIE) as MovieDetail
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}