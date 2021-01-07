package com.fernandodominguezpacheco.moviedb.domain

data class Actor(
    val id: Int = 0,
    val name: String = "",
    val popularity: Double = 0.0,
    val urlImage: String = "",
    val character: String = ""
) {
}