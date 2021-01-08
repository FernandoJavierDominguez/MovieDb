package com.fernandodominguezpacheco.moviedb.framework.db

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieActorDataSource
import com.fernandodominguezpacheco.moviedb.domain.MovieActor
import com.fernandodominguezpacheco.moviedb.framework.toRoomMovieActor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomMovieActorDataSource(db: MovieDb) : LocalMovieActorDataSource {

    private val movieActorDao = db.movieActor()

    override suspend fun addMovieActor(movieActor: MovieActor) {
        withContext(Dispatchers.IO){
            movieActorDao.addMovieActor(movieActor.toRoomMovieActor())
        }
    }

    override suspend fun addMoviesActors(moviesActors: List<MovieActor>) {
        withContext(Dispatchers.IO){
            movieActorDao.addMoviesActors(moviesActors.map { it.toRoomMovieActor() })
        }
    }
}