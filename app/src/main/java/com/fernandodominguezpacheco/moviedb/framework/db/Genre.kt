package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Genre(
    @PrimaryKey (autoGenerate = false) val id: Int,
    val name: String
)