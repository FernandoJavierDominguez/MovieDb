package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(primaryKeys = ["movieId","actorId"])
data class MovieActor(
    val movieId: Int,
    val actorId: Int
) {
}