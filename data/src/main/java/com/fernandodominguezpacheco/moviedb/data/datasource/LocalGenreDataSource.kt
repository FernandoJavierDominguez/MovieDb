package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Genre
import kotlinx.coroutines.flow.Flow

interface LocalGenreDataSource {

    suspend fun addGenres(genres: List<Genre>)
    //fun getAllGenresByMovie(movieId: Int) : Flow<List<Genre>>

}