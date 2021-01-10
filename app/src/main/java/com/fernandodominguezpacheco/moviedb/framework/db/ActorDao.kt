package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow


@Dao
interface ActorDao {

    @Insert
    suspend fun addActors(actors: List<Actor>)

    @Query("SELECT * FROM Actor")
    fun getAllActors() : Flow<List<Actor>>

    @Query("SELECT COUNT(actorId) FROM Actor")
    suspend fun actorCount() : Int

}