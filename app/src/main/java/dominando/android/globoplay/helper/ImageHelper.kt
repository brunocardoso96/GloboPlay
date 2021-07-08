package dominando.android.globoplay.helper

import android.widget.ImageView
import com.squareup.picasso.Picasso
import dominando.android.globoplay.data.network.Api

object ImageHelper  {
    fun insertImage(imageView: ImageView, imageUrl: String) {
        val url = Api.IMAGESERVICE + imageUrl
        Picasso.get().load(url).into(imageView)
    }
}
