package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Movie


interface RemoteMovieDataSource {

    suspend fun getAllMovies(): List<Movie>

}