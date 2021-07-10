package dominando.android.globoplay.ui.feature.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.databinding.RvHomeListMovieBinding
import dominando.android.globoplay.helper.loadImage

class HomeMovieAdapter(
    private val list: List<Movie>,
    private val onItemClickListener: (movie: Movie) -> Unit
) : RecyclerView.Adapter<HomeMovieAdapter.MyViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie {
        return MyViewHolderMovie(
            RvHomeListMovieBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie, position: Int) {
        val movies = list[position]
        with(holder.binding) {
            imgMovie.loadImage(movies.image)
            imgMovie.setOnClickListener {
                onItemClickListener.invoke(movies)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolderMovie(val binding: RvHomeListMovieBinding) :
        RecyclerView.ViewHolder(binding.root)
}