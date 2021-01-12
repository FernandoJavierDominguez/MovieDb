package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MovieActorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovieActor(movieActor: MovieActor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMoviesActors(moviesActors: List<MovieActor>)

}