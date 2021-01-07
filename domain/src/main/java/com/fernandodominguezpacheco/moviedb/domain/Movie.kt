package com.fernandodominguezpacheco.moviedb.domain

import java.util.*

data class Movie(
    val id: Int = 0,
    val title: String = "",
    val original_language: String = "",
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    val imdbId: String = "",
    val popularity: Double = 0.0,
    val homepage: String = "",
    val overview: String = "",
    val release_date : Date = Date(),
    val urlImage: String = "",
    val status: String = "",
    val actors: List<Actor> = emptyList(),
    val genres: List<Genre> = emptyList()
) {
}