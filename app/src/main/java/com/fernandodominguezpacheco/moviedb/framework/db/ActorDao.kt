package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface ActorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addActors(actors: List<Actor>)

    @Query("SELECT * FROM Actor")
    fun getAllActors() : Flow<List<Actor>>

    @Query("SELECT COUNT(actorId) FROM Actor")
    suspend fun actorCount() : Int

}