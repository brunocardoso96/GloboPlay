package dominando.android.globoplay.ui.feature.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.databinding.RvHomeListGenreBinding
import dominando.android.globoplay.ui.feature.moviedetail.activity.MovieDetailActivity

class HomeGenreAdapter : RecyclerView.Adapter<HomeGenreAdapter.MyViewHolderGenre>() {

    private val movieToGenre = ArrayList<MovieToGenre>()

    fun addMovieToGenre(list: List<MovieToGenre>) {
        movieToGenre.clear()
        movieToGenre.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderGenre {
        return MyViewHolderGenre(
            RvHomeListGenreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holderGenre: MyViewHolderGenre, position: Int) {
        val movie = movieToGenre[position]
        with(holderGenre.binding) {
            titleGenre.text = movie.name
            setListMovieToGenre(rvMovie, movie.listMovie)
        }
    }

    override fun getItemCount(): Int = movieToGenre.size

    class MyViewHolderGenre(val binding: RvHomeListGenreBinding) :
        RecyclerView.ViewHolder(binding.root)

    private fun setListMovieToGenre(recyclerView: RecyclerView, list: List<Movie>) {
        val itemRecyclerView = HomeMovieAdapter(list) {
            val intent = MovieDetailActivity.getIntentMovieDetail(recyclerView.context)
            intent.putExtra(MovieDetailActivity.EXTRA_ID, it.id)
            startActivity(recyclerView.context, intent, null)
        }
        recyclerView.layoutManager =
            LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerView
    }
}