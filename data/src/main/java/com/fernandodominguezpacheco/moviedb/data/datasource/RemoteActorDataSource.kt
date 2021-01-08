package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Actor
import kotlinx.coroutines.flow.Flow

interface RemoteActorDataSource {

    suspend fun getAllActorsByMovie(movieId: Int, apiKey: String): List<Actor>

}