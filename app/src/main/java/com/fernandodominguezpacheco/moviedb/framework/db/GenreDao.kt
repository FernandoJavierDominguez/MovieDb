package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GenreDao {

    @Insert
    suspend fun addGenres(genres: List<Genre>)

    @Query ("SELECT * FROM Genre")
    fun getAllGenres() : Flow<List<Genre>>

    @Query ("SELECT COUNT(id) FROM Genre")
    suspend fun countGenre() : Int

}