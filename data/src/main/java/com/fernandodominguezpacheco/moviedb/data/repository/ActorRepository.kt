package com.fernandodominguezpacheco.moviedb.data.repository

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalActorDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteActorDataSource
import com.fernandodominguezpacheco.moviedb.domain.Actor
import kotlinx.coroutines.flow.Flow

class ActorRepository(
    private val localActorDataSource: LocalActorDataSource,
    private val remoteActorDataSource: RemoteActorDataSource
) {

    suspend fun addActors(){
        if(localActorDataSource.isEmpty()){
            localActorDataSource.addActors(remoteActorDataSource.getAllActors())
        }
    }
    fun getAllActors() : Flow<List<Actor>> = localActorDataSource.getAllActorsWithMovies()

}