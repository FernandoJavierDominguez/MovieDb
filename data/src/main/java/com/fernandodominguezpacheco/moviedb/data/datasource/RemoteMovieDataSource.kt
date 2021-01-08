package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Movie


interface RemoteMovieDataSource {

    suspend fun getAllMovies(apiKey: String, language: String, page: Int): List<Movie>

}