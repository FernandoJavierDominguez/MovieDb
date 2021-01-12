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

class ServerGenreDataSource(
    private val apiService: MoviesApiService
) : RemoteGenreDataSource{

    override suspend fun getAllGenresByMovie(movieId: Int, apiKey: String): List<Genre> {
        return apiService.getGenresByMovie(movieId, apiKey).genres.map{
            it.toGenre()
        }
    }


}