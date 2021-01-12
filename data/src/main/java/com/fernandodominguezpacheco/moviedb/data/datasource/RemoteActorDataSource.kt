package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Actor

interface RemoteActorDataSource {

    suspend fun getAllActorsByMovie(movieId: Int, apiKey: String): List<Actor>

}