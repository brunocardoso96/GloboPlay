package dominando.android.globoplay.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import dominando.android.globoplay.data.network.Api
import dominando.android.globoplay.data.response.GenresItemDetail


fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(Api.IMAGESERVICE + imageUrl)
        .centerCrop()
        .into(this)
}

fun List<GenresItemDetail>.concatGenre(): String {
    var string = ""
    var first = true
    this.forEach {
        if(first){
            string = it.name
            first = false
        }
        string += ", ${it.name}"
    }
    return string
}
