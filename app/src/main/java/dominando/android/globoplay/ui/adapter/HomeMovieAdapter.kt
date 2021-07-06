package dominando.android.globoplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.activity.Movie
import kotlinx.android.synthetic.main.rv_list_movie.view.*

class HomeMovieAdapter(
    private val list: List<Movie>,
    private val onItemClickListener: (movie: Movie) -> Unit
) : RecyclerView.Adapter<HomeMovieAdapter.MyViewHolderMovie>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderMovie {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_list_movie, parent, false)
        return MyViewHolderMovie(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MyViewHolderMovie, position: Int) {
        holder.bindView(list[position])
    }

    override fun getItemCount(): Int = list.size


    class MyViewHolderMovie(itemView: View, private val onItemClickListener: (movie: Movie) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val imgMovie = itemView.imgMovie

        fun bindView(holder: Movie) {
            itemView.setOnClickListener {
                onItemClickListener.invoke(holder)
            }
        }
    }
}