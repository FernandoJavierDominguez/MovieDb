package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Genre

interface RemoteGenreDataSource {

    suspend fun getAllGenresByMovie(movieId: Int, apiKey: String): List<Genre>

}