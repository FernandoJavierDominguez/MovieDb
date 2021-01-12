package com.fernandodominguezpacheco.moviedb.framework.server

import com.google.gson.annotations.SerializedName

class MovieServerResult(
    val page: Int,
    val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)