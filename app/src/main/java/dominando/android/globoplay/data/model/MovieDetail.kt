package dominando.android.globoplay.data.model

import dominando.android.globoplay.data.response.GenresItemDetail

data class MovieDetail(
    val title: String,
    val genres: List<GenresItemDetail>,
    val runtime: Int,
    val overview: String,
    val releaseDate: String,
    val languages: String,
    val postPath: String
)