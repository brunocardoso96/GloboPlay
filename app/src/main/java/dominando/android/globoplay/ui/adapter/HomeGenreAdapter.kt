package dominando.android.globoplay.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dominando.android.globoplay.R
import dominando.android.globoplay.ui.activity.Genre
import kotlinx.android.synthetic.main.rv_home_list_genre.view.*

class HomeGenreAdapter(private val list: List<Genre>) :
    RecyclerView.Adapter<HomeGenreAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_home_list_genre, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int = list.size


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.titleGenre

        fun bind(holder: Genre) {
            title.text = holder.name
        }
    }

}


/*
override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(listMovie[position])
    }

    class ViewHolder(itemView: View, private val onItemClickListener: (movie: Movie) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val imageHelper: ImageHelper = ImageHelper()

        private val title = itemView.textTitle
        private val imageUrl = itemView.imageMovie

        fun bindView(holder: Movie) {
            title.text = holder.title
            imageHelper.insertImage(holder.cover_url, imageUrl)

            itemView.setOnClickListener{
                onItemClickListener.invoke(holder)
            }
        }
 */