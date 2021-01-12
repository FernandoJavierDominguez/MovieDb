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

class ServerMovieDataSource(
    private val apiService: MoviesApiService
) : RemoteMovieDataSource{

    override suspend fun getAllMovies(apiKey: String, language: String, page: Int): List<Movie> {
        return apiService.getMovies(apiKey,language,page).results.map{
            it.toMovie()
        }
    }

}