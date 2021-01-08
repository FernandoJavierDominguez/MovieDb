package com.fernandodominguezpacheco.moviedb.framework.db

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalGenreDataSource
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.framework.toRoomGenre
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomGenreDataSource(db: MovieDb) : LocalGenreDataSource {

    private val genreDao = db.genreDao()

    override suspend fun addGenres(genres: List<Genre>) {
        withContext(Dispatchers.IO){
            genreDao.addGenres(genres.map { it.toRoomGenre() })
        }
    }
}