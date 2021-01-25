package com.fernandodominguezpacheco.moviedb.framework.db

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieDataSource
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.framework.toMovie
import com.fernandodominguezpacheco.moviedb.framework.toRoomMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class RoomMovieDataSource(db: MovieDb) : LocalMovieDataSource {

    private val movieDao = db.movieDao()

    override suspend fun addMovies(movies: List<Movie>) {
        withContext(Dispatchers.IO){
            movieDao.addMovies(movies.map{ it.toRoomMovie() })
        }
    }

    override fun getAllMovies(): Flow<List<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getAllMoviesWithGenresAndActors(): Flow<List<Movie>> = movieDao.getAllMoviesWithActorsAndGenre().map {
        movies -> movies.map {
            it.toMovie()
        }
    }

    override fun getMovieByIdWithGenresAndActors(movieId: Int): Flow<Movie> {
        return movieDao.getMovieByIdWithGenresAndGenre(movieId).map{
            it.toMovie()
        }
    }

    override suspend fun getMovieById(id: Int): Movie {
        TODO("Not yet implemented")
    }

    override suspend fun isEmpty(): Boolean = movieDao.movieCount() <= 0

    override suspend fun deleteAllMovies() {
        TODO("Not yet implemented")
    }

    override fun getAllMoviesWithGenresAndActorsBySearch(text: String): Flow<List<Movie>> = movieDao.getAllMoviesWithActorsAndGenreBySearch(text).map {
        movies -> movies.map {
            it.toMovie()
        }
    }
}