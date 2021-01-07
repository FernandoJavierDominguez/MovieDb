package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["movieId","genreId"])
data class MovieGenre(
    val movieId: Int,
    val genreId: Int
) {
}