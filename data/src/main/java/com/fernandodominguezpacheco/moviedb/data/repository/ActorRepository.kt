package com.fernandodominguezpacheco.moviedb.data.repository

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalActorDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieActorDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteActorDataSource
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.MovieActor
import kotlinx.coroutines.flow.Flow

class ActorRepository(
    private val localActorDataSource: LocalActorDataSource,
    private val remoteActorDataSource: RemoteActorDataSource,
    private val localMovieActorDataSource: LocalMovieActorDataSource,
    private val apiKey: String
) {

    suspend fun addActorsByMovie(movieId: Int){
        val actors = remoteActorDataSource.getAllActorsByMovie(movieId, apiKey)
        localActorDataSource.addActors(actors)
        actors.forEach {
            val movieActor = MovieActor(movieId, it.id)
            localMovieActorDataSource.addMovieActor(movieActor)
        }
    }



}