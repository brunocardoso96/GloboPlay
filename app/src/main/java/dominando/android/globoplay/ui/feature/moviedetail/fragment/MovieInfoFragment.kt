package dominando.android.globoplay.ui.feature.moviedetail.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.databinding.FragmentMovieInfoBinding
import dominando.android.globoplay.ui.feature.moviedetail.viewmodel.MovieInfoViewModel

class MovieInfoFragment : Fragment() {

    private lateinit var movieInfoViewModel: MovieInfoViewModel
    private var _binding: FragmentMovieInfoBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieInfoViewModel = ViewModelProvider(this).get(MovieInfoViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 2)

        }
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

    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"
        @JvmStatic
        fun newInstance(sectionNumber: Int): MovieInfoFragment {
            return MovieInfoFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}