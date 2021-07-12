package dominando.android.globoplay.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import dominando.android.globoplay.data.network.Api
import dominando.android.globoplay.data.response.GenresItemDetail
import jp.wasabeef.glide.transformations.BlurTransformation


fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(Api.IMAGESERVICE + imageUrl)
        .centerCrop()
        .into(this)
}

fun ImageView.blurImage(imageUrl: String) {
    Glide.with(this)
        .load(Api.IMAGESERVICE + imageUrl)
        .centerCrop()
        .apply(bitmapTransform(BlurTransformation(20, 1)))
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
