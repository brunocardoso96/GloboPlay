package dominando.android.globoplay.helper

import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import dominando.android.globoplay.data.network.Api
import dominando.android.globoplay.data.response.GenresItemDetail
import jp.wasabeef.glide.transformations.BlurTransformation


fun ImageView.loadImage(imageUrl: String, blur: Boolean = false) {
    val glide = Glide.with(this)
        .load(Api.IMAGESERVICE + imageUrl)
        .centerCrop()
    if (blur) glide.apply(bitmapTransform(BlurTransformation(20, 1)))
    glide.into(this)
}

fun List<GenresItemDetail>.concatGenre(): String {
    var string = ""
    var first = true
    this.forEach {
        if (first) {
            string = it.name
            first = false
        } else{
            string += ", ${it.name}"
        }
    }
    return string
}

