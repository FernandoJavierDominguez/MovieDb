package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(movies: List<Movie>)

    @Transaction @Query("SELECT * FROM Movie")
    fun getAllMoviesWithActorsAndGenre() : Flow<List<MovieWithActorsAndGenres>>

    @Query("SELECT COUNT(movieId) FROM Movie")
    suspend fun movieCount() : Int



}