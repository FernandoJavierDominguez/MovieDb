package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MovieGenreDao {

    @Insert
    suspend fun addMovieGenre(movieGenre: MovieGenre)

    @Insert
    suspend fun addMoviesGenres(moviesGenres: List<MovieGenre>)

}