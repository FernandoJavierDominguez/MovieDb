package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Actor (
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val popularity: Double,
    val urlImage: String,
    val character: String
)