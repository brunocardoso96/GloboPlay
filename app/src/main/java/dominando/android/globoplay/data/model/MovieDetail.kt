package dominando.android.globoplay.data.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import dominando.android.globoplay.data.response.GenresItemDetail
import java.io.Serializable

@SuppressLint("ParcelCreator")
data class MovieDetail(
    val title: String,
    val genres: List<GenresItemDetail>,
    val runtime: Int,
    val overview: String,
    val releaseDate: String,
    val languages: String,
    val postPath: String
): Parcelable {
    override fun describeContents(): Int = 0

    override fun writeToParcel(desc: Parcel?, p1: Int) {
        desc?.writeString(title)
        desc?.writeList(genres)
        desc?.writeInt(runtime)
        desc?.writeString(overview)
        desc?.writeString(releaseDate)
        desc?.writeString(languages)
    }
}