package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Movie(
    @PrimaryKey (autoGenerate = false) val id: Int,
    val title: String,
    val original_language: String,
    val vote_average: Double,
    val vote_count: Int,
    val imdbId: String,
    val popularity: Double,
    val homepage: String,
    val overview: String,
    val release_date : Date,
    val urlImage: String,
    val status: String
) {
}