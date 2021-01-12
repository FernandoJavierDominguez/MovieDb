package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MovieGenreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieGenre(movieGenre: MovieGenre)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMoviesGenres(moviesGenres: List<MovieGenre>)

}