package com.fernandodominguezpacheco.moviedb.framework.db

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieGenreDataSource
import com.fernandodominguezpacheco.moviedb.domain.MovieGenre
import com.fernandodominguezpacheco.moviedb.framework.toRoomMovieGenre
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomMovieGenreDataSource(db: MovieDb) : LocalMovieGenreDataSource {

    private val movieGenreDao = db.movieGenre()

    override suspend fun addMovieGenre(movieGenre: MovieGenre) {
        withContext(Dispatchers.IO){
            movieGenreDao.addMovieGenre(movieGenre.toRoomMovieGenre())
        }
    }

    override suspend fun addMoviesGenres(moviesGenres: List<MovieGenre>) {
        withContext(Dispatchers.IO){
            movieGenreDao.addMoviesGenres(moviesGenres.map { it.toRoomMovieGenre() })
        }
    }
}