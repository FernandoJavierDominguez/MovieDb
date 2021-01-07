package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.Actor

interface RemoteActorDataSource {

    suspend fun getAllActors(): List<Actor>


}