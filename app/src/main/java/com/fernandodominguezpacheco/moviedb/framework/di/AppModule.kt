package com.fernandodominguezpacheco.moviedb.framework.di

import android.app.Application
import androidx.room.Room
import com.fernandodominguezpacheco.moviedb.BuildConfig
import com.fernandodominguezpacheco.moviedb.data.datasource.*
import com.fernandodominguezpacheco.moviedb.framework.db.*
import com.fernandodominguezpacheco.moviedb.framework.server.MoviesApiDataSource
import com.fernandodominguezpacheco.moviedb.framework.server.MoviesApiService
import com.fernandodominguezpacheco.moviedb.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {

    //LOCAL
    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        MovieDb::class.java,
        "movie-db"
    ).build()

    @Provides
    fun localMovieDataSourceProvider(db: MovieDb) : LocalMovieDataSource = RoomMovieDataSource(db)

    @Provides
    fun localActorDataSourceProvider(db: MovieDb) : LocalActorDataSource = RoomActorDataSource(db)

    @Provides
    fun localGenreDataSourceProvider(db: MovieDb) : LocalGenreDataSource = RoomGenreDataSource(db)

    @Provides
    fun localMovieActorProvider(db: MovieDb) : LocalMovieActorDataSource = RoomMovieActorDataSource(db)

    @Provides
    fun localMovieGenreProvider(db: MovieDb) : LocalMovieGenreDataSource = RoomMovieGenreDataSource(db)


    //SERVER
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL


    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): MoviesApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
        .run{ create(MoviesApiService::class.java) }

    @Provides
    fun remoteMoviesDataSourceProvider(apiService: MoviesApiService) : RemoteMovieDataSource = MoviesApiDataSource(apiService)


}