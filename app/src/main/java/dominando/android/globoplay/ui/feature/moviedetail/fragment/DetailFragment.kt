package dominando.android.globoplay.ui.feature.moviedetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dominando.android.globoplay.data.model.MovieDetail
import dominando.android.globoplay.databinding.FragmentMovieInfoBinding
import dominando.android.globoplay.helper.observeResource
import dominando.android.globoplay.ui.feature.moviedetail.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieInfoBinding
    private lateinit var viewModel: DetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieInfoBinding.inflate(layoutInflater)
        val root = binding.root
        return root
    }

    private fun initialize() {
        setupViewModel()
        setupDetail()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
    }

    private fun setupDetail() {
//        viewModel.movieLiveData.observeResource(this) {
//
//        }
    }
//    private fun setLayout() {
//        arguments?.getParcelable<MovieDetail>(EXTRA_TITLE_MOVIE)?.let { viewModel.getMovieDetail(it) }
//    }

    companion object {
        const val TITLE_DETAIL = "Detalhes"
    }

    fun setMovie(movie: MovieDetail){
        binding.txtOriginalTitle.text = movie.title
    }
}
