package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Actor
import kotlinx.coroutines.flow.Flow

interface LocalActorDataSource {

    suspend fun addActors(actors: List<Actor>)
    fun getAllActors(): Flow<List<Actor>>
    fun getAllActorsWithMovies(): Flow<List<Actor>>
    suspend fun getActorById(id: Int) : Actor
    suspend fun isEmpty() : Boolean
    suspend fun deleteAllActors()

}