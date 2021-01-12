package com.fernandodominguezpacheco.moviedb.framework.server

import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteActorDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteGenreDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteMovieDataSource
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.framework.toActor
import com.fernandodominguezpacheco.moviedb.framework.toGenre
import com.fernandodominguezpacheco.moviedb.framework.toMovie

class ServerActorDataSource(
    private val apiService: MoviesApiService
) : RemoteActorDataSource{


    override suspend fun getAllActorsByMovie(movieId: Int, apiKey: String): List<Actor> {
        return apiService.getActorsByMovie(movieId, apiKey).list.map{
            it.toActor()
        }
    }



}