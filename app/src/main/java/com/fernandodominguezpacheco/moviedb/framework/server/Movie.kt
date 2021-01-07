package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Int,
) {
}