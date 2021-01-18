package com.fernandodominguezpacheco.moviedb.data.repository

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalGenreDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieGenreDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteGenreDataSource
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.domain.MovieGenre
import kotlinx.coroutines.flow.Flow

class GenreRepository(
    private val localGenreDataSource: LocalGenreDataSource,
    private val remoteGenreDataSource: RemoteGenreDataSource,
    private val localMovieGenreDataSource: LocalMovieGenreDataSource,
    private val apiKey: String
) {

    suspend fun addGenreByMovie(movieId: Int){
        val genres = remoteGenreDataSource.getAllGenresByMovie(movieId,apiKey)
        localGenreDataSource.addGenres(genres)
        genres.forEach {
            val movieGenre = MovieGenre(movieId, it.id)
            localMovieGenreDataSource.addMovieGenre(movieGenre)
        }

    }

    //fun getGenresByMovie(movieId: Int) : Flow<List<Genre>> = localGenreDataSource.getAllGenresByMovie(movieId)

}