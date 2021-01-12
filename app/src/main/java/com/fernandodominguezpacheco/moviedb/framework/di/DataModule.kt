package com.fernandodominguezpacheco.moviedb.framework.di

import com.fernandodominguezpacheco.moviedb.data.datasource.*
import com.fernandodominguezpacheco.moviedb.data.repository.ActorRepository
import com.fernandodominguezpacheco.moviedb.data.repository.GenreRepository
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Named

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun movieRepositoryProvider(
        localMovieDataSource: LocalMovieDataSource,
        remoteMovieDataSource: RemoteMovieDataSource,
        localMovieActorDataSource: LocalMovieActorDataSource,
        localMovieGenreDataSource: LocalMovieGenreDataSource,
        actorRepository: ActorRepository,
        genreRepository: GenreRepository,
        @Named("apiKey") apiKey: String,
        @Named("language") language: String
    ) = MovieRepository(localMovieDataSource, remoteMovieDataSource, localMovieActorDataSource, localMovieGenreDataSource, actorRepository, genreRepository, apiKey, language)

    @Provides
    fun actorRepositoryProvider(
        localActorDataSource: LocalActorDataSource,
        remoteActorDataSource: RemoteActorDataSource,
        localMovieActorDataSource: LocalMovieActorDataSource,
        @Named("apiKey") apiKey: String
    ) = ActorRepository(localActorDataSource, remoteActorDataSource,localMovieActorDataSource,apiKey)

    @Provides
    fun genreRepositoryProvider(
        localGenreDataSource: LocalGenreDataSource,
        remoteGenreDataSource: RemoteGenreDataSource,
        localMovieGenreDataSource: LocalMovieGenreDataSource,
        @Named("apiKey") apiKey: String
    ) = GenreRepository(localGenreDataSource, remoteGenreDataSource, localMovieGenreDataSource, apiKey)

}