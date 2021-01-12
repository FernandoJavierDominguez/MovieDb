package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("original_language") val original_language: String,
    @SerializedName("vote_average") val vote_average: Double,
    @SerializedName("vote_count") val vote_count: Int,
    @SerializedName("imdbId") val imdbId: String?,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("homepage") val homepage: String?,
    @SerializedName("overview") val overview: String?,
    @SerializedName("release_date") val release_date : Date,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("status") val status: String?,
    @SerializedName("genres") val genres: List<Genre>
) {
}