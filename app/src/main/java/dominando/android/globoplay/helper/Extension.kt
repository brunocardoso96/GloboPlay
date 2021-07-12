package dominando.android.globoplay.helper

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import dominando.android.globoplay.data.network.Api
import dominando.android.globoplay.data.response.GenresItemDetail
import jp.wasabeef.glide.transformations.BlurTransformation
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


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

sealed class Resource<T> {

    data class Success<T>(val data: T?) : Resource<T>()
    data class Error<T>(val throwable: Throwable?) : Resource<T>()
    data class ErrorData<T>(val throwable: Throwable?, val `data`: T) : Resource<T>()
    class Loading<T>(val isLoading: Boolean) : Resource<T>()

    companion object {
        fun <T> success(data: T?): Resource<T> = Success(data)
        fun <T> error(throwable: Throwable?): Resource<T> = Error(throwable)
        fun <T> loading(isLoading: Boolean): Resource<T> = Loading(isLoading)
        fun <T> errorData(
            throwable: Throwable?,
            `data`: T
        ): Resource<T> = ErrorData(throwable, data)
    }
}

fun <T> LiveData<Resource<T>>.observeResource(
    owner: LifecycleOwner,
    onSuccess: (T) -> Unit,
    onError: (Throwable) -> Unit,
    onLoading: ((Boolean) -> Unit)? = null
) {

    observe(owner, Observer { resource ->
        when (resource) {
            is Resource.Success -> resource.data?.let { onSuccess.invoke(it) }
            is Resource.Error -> resource.throwable?.let { onError.invoke(it) }
            is Resource.Loading -> onLoading?.invoke(resource.isLoading)
        }
    })
}

fun <T> LiveData<Resource<T>>.observeResource(
    owner: LifecycleOwner,
    onSuccess: (T) -> Unit
) {
    observe(owner, Observer<Resource<T>> { resource ->
        if (resource is Resource.Success) {
            resource.data?.let { onSuccess.invoke(it) }
        }
    })
}

