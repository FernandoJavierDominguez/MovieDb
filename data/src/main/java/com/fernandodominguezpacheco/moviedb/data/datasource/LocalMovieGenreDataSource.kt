package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.MovieGenre

interface LocalMovieGenreDataSource {

    suspend fun addMovieGenre(movieGenre: MovieGenre)

    suspend fun addMoviesGenres(moviesGenres: List<MovieGenre>)

}