package com.fernandodominguezpacheco.moviedb.framework.db

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalActorDataSource
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.framework.toActor
import com.fernandodominguezpacheco.moviedb.framework.toRoomActor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RoomActorDataSource(db: MovieDb) : LocalActorDataSource {

    private val actorDao = db.actorDao()

    override suspend fun addActors(actors: List<Actor>) {
        withContext(Dispatchers.IO){
            actorDao.addActors(actors.map { it.toRoomActor() })
        }
    }

    override fun getAllActors(): Flow<List<Actor>> = actorDao.getAllActors().map {
       actors-> actors.map{
           it.toActor()
       }
    }


    override fun getAllActorsWithMovies(): Flow<List<Actor>> {
        TODO("Not yet implemented")
    }

    override suspend fun getActorById(id: Int): Actor {
        TODO("Not yet implemented")
    }

    override suspend fun isEmpty(): Boolean = actorDao.actorCount() <= 0

    override suspend fun deleteAllActors() {
        TODO("Not yet implemented")
    }
}