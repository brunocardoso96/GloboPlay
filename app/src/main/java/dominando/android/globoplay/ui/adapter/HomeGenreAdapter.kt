package dominando.android.globoplay.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.activity.Genre
import dominando.android.globoplay.ui.activity.Movie
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeGenreAdapter(
    private val context: Context,
    private val listGenre: List<Genre>,
    private val listMovie: List<Movie>
) : RecyclerView.Adapter<HomeGenreAdapter.MyViewHolderGenre>() {

    private var listMovieToGenre: MutableList<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderGenre {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_home_list_genre, parent, false)
        return MyViewHolderGenre(itemView)
    }

    override fun onBindViewHolder(holderGenre: MyViewHolderGenre, position: Int) {
        holderGenre.bind(listGenre[position])
        setListMovieToGenre(holderGenre.rvlistMovie, setupMovieToGenre())
    }

    override fun getItemCount(): Int = listGenre.size

    class MyViewHolderGenre(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val rvlistMovie: RecyclerView = itemView.findViewById(R.id.rvMovie)
        private val title = itemView.titleGenre

        fun bind(holder: Genre) {
            title.text = holder.name
        }
    }

    fun setListMovieToGenre(recyclerView: RecyclerView, list: List<Movie>) {
        val itemRecyclerView = HomeMovieAdapter(list) {
            Log.i("CLICKMOVIE", "Sucesso")
        }
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerView
    }

    fun setupMovieToGenre(): MutableList<Movie> {
        listGenre.forEach { genre ->
            listMovie.forEach { movie ->
                movie.genre.forEach { idGenre ->
                    val movieFilter = idGenre.filter { it.toString() == genre.id }
                    if(movieFilter == genre.id) listMovieToGenre.add(Movie(movie.id, movie.name, movie.genre, movie.imageUrl))
                }
            }
        }
        return listMovieToGenre
    }
}