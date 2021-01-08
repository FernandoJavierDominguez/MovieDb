package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MovieActorDao {

    @Insert
    suspend fun addMovieActor(movieActor: MovieActor)

    @Insert
    suspend fun addMoviesActors(moviesActors: List<MovieActor>)

}