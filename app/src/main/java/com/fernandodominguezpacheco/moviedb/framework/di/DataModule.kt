package com.fernandodominguezpacheco.moviedb.framework.di

import com.fernandodominguezpacheco.moviedb.data.datasource.*
import com.fernandodominguezpacheco.moviedb.data.repository.ActorRepository
import com.fernandodominguezpacheco.moviedb.data.repository.GenreRepository
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun movieRepositoryProvider(
        localMovieDataSource: LocalMovieDataSource,
        remoteMovieDataSource: RemoteMovieDataSource,
        localMovieActorDataSource: LocalMovieActorDataSource,
        localMovieGenreDataSource: LocalMovieGenreDataSource,
        apiKey: String,
        language: String ) = MovieRepository(localMovieDataSource, remoteMovieDataSource, localMovieActorDataSource, localMovieGenreDataSource, apiKey, language)

    @Provides
    fun actorRepositoryProvider(
        localActorDataSource: LocalActorDataSource,
        remoteActorDataSource: RemoteActorDataSource,
        localMovieActorDataSource: LocalMovieActorDataSource,
        apiKey: String
    ) = ActorRepository(localActorDataSource, remoteActorDataSource,localMovieActorDataSource,apiKey)

    @Provides
    fun genreRepositoryProvider(
        localGenreDataSource: LocalGenreDataSource,
        remoteGenreDataSource: RemoteGenreDataSource,
        localMovieGenreDataSource: LocalMovieGenreDataSource,
        apiKey: String
    ) = GenreRepository(localGenreDataSource, remoteGenreDataSource, localMovieGenreDataSource, apiKey)

}