package dominando.android.globoplay.ui.feature.home.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.data.model.MovieToGenre
import dominando.android.globoplay.ui.feature.moviedetail.activity.MovieDetailActivity
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeGenreAdapter(
//    private val context: Context,
//    private val movieToGenre: List<MovieToGenre>,
) : RecyclerView.Adapter<HomeGenreAdapter.MyViewHolderGenre>() {

    private val movieToGenre = ArrayList<MovieToGenre>()

    fun addMovieToGenre(list: List<MovieToGenre>) {
        movieToGenre.clear()
        movieToGenre.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderGenre {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_home_list_genre, parent, false)
        return MyViewHolderGenre(itemView)
    }

    override fun onBindViewHolder(holderGenre: MyViewHolderGenre, position: Int) {
        holderGenre.bind(movieToGenre[position])
        setListMovieToGenre(holderGenre.rvlistMovie, movieToGenre[position].listMovie)
    }

    override fun getItemCount(): Int = movieToGenre.size

    class MyViewHolderGenre(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvlistMovie: RecyclerView = itemView.findViewById(R.id.rvMovie)
        private val title = itemView.titleGenre

        fun bind(holder: MovieToGenre) {
            title.text = holder.name
        }
    }

    fun setListMovieToGenre(recyclerView: RecyclerView, list: List<Movie>) {
        val itemRecyclerView = HomeMovieAdapter(list) {
            val intent = MovieDetailActivity.getIntentMovieDetail(recyclerView.context)
            startActivity(recyclerView.context, intent, null)
        }
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerView
    }
}