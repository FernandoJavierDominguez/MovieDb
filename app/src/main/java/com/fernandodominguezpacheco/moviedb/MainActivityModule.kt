package com.fernandodominguezpacheco.moviedb

import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import dagger.Module
import dagger.Provides


@Module
class MainActivityModule {

    @Provides
    fun getAllMoviesProvider(movieRepository: MovieRepository) = GetAllMovies(movieRepository)

}