package com.fernandodominguezpacheco.moviedb.data.datasource

import com.fernandodominguezpacheco.moviedb.domain.MovieActor

interface LocalMovieActorDataSource {

    suspend fun addMovieActor(movieActor: MovieActor)

    suspend fun addMoviesActors(moviesActors: List<MovieActor>)

}