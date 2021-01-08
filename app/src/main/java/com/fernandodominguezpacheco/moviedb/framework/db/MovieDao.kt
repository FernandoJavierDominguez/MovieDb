package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert
    suspend fun addMovies(movies: List<Movie>)

    @Transaction @Query("SELECT * FROM Movie")
    fun getAllMoviesWithActorsAndGenre() : Flow<List<MovieWithActorsAndGenres>>

    @Query("SELECT COUNT(id) FROM Movie")
    suspend fun movieCount() : Int



}