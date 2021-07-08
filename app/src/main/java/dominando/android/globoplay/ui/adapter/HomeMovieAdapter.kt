package dominando.android.globoplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.data.model.Movie
import dominando.android.globoplay.helper.ImageHelper
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
        val itemImage: ImageView = itemView.imgMovie

        fun bindView(holder: Movie) {
            ImageHelper.insertImage(itemImage, holder.image)
            itemView.setOnClickListener {
                onItemClickListener.invoke(holder)
            }
        }
    }
}