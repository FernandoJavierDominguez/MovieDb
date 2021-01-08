package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Genre

interface LocalGenreDataSource {

    suspend fun addGenres(genres: List<Genre>)

}