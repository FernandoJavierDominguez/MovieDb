package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Movie
import kotlinx.coroutines.flow.Flow

interface LocalMovieDataSource {

    suspend fun addMovies(movies: List<Movie>)
    fun getAllMovies(): Flow<List<Movie>>
    fun getAllMoviesWithGenresAndActors(): Flow<List<Movie>>
    fun getMovieByIdWithGenresAndActors(movieId: Int): Flow<Movie>
    suspend fun getMovieById(id: Int) : Movie
    suspend fun isEmpty() : Boolean
    suspend fun deleteAllMovies()
    fun getAllMoviesWithGenresAndActorsBySearch(text: String): Flow<List<Movie>>
}