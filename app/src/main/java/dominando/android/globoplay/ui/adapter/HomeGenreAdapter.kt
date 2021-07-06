package dominando.android.globoplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.activity.Genre
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeGenreAdapter(private val list: List<Genre>) :
    RecyclerView.Adapter<HomeGenreAdapter.MyViewHolderGenre>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderGenre {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_home_list_genre, parent, false)
        return MyViewHolderGenre(itemView)
    }

    override fun onBindViewHolder(holderGenre: MyViewHolderGenre, position: Int) {
        holderGenre.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MyViewHolderGenre(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.titleGenre

        fun bind(holder: Genre) {
            title.text = holder.name
        }
    }
}