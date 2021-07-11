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

    private lateinit var movieInfoViewModel: DetailViewModel
    private var _binding: FragmentMovieInfoBinding? = null

    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieInfoViewModel = ViewModelProvider(this).get(DetailViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 2)

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieInfoBinding.inflate(inflater, container, false)
        val root = binding.root

        movieInfoViewModel.text.observe(viewLifecycleOwner, Observer {

        })

        return root

    }

    private fun initialize() {
        val movieDetail = arguments?.getParcelable<MovieDetail>(EXTRA_TITLE_MOVIE)
        Log.i(EXTRA_TITLE_MOVIE, "${movieDetail.toString()}")
    }

    companion object {
        const val TITLE_DETAIL = "Detalhes"
        const val EXTRA_TITLE_MOVIE = "EXTRA_TITLE_MOVIE"
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(movieDetail: MovieDetail?): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                   putParcelable(EXTRA_TITLE_MOVIE, movieDetail)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}