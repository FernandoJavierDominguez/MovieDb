package com.fernandodominguezpacheco.moviedb

import android.app.Application
import android.content.Context
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import com.fernandodominguezpacheco.moviedb.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class MainActivityModule(private val application: Application) {

    @Provides
    fun getAllMoviesProvider(movieRepository: MovieRepository) = GetAllMovies(movieRepository)

}