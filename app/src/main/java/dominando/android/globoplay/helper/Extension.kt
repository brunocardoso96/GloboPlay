package dominando.android.globoplay.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import dominando.android.globoplay.data.network.Api


fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this)
        .load(Api.IMAGESERVICE + imageUrl)
        .centerCrop()
        .into(this)
}
