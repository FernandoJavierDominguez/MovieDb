package com.fernandodominguezpacheco.moviedb.data.repository

import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieActorDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.LocalMovieGenreDataSource
import com.fernandodominguezpacheco.moviedb.data.datasource.RemoteMovieDataSource
import com.fernandodominguezpacheco.moviedb.domain.Movie
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieActorDataSource: LocalMovieActorDataSource,
    private val localMovieGenreDataSource: LocalMovieGenreDataSource,
    private val actorRepository: ActorRepository,
    private val genreRepository: GenreRepository,
    private val apiKey: String,
    private val language: String
) {

    suspend fun addMoviesWithActorsAndGenres(page: Int){
        if(localMovieDataSource.isEmpty()){
            val movies = remoteMovieDataSource.getAllMovies(apiKey, language, page )
            localMovieDataSource.addMovies(movies)
            movies.forEach {
                actorRepository.addActorsByMovie(it.id)
                genreRepository.addGenreByMovie(it.id)
            }
        }
    }
    suspend fun addMovies(page: Int){
        if(localMovieDataSource.isEmpty()){
            localMovieDataSource.addMovies(remoteMovieDataSource.getAllMovies(apiKey,language,page))
        }
    }

    fun getAllMovies() : Flow<List<Movie>> = localMovieDataSource.getAllMoviesWithGenresAndActors()

    fun getMoviesBySearch(text: String) : Flow<List<Movie>> = localMovieDataSource.getAllMoviesWithGenresAndActorsBySearch(text)


    fun getMovieById(movieId: Int) : Flow<Movie> = localMovieDataSource.getMovieByIdWithGenresAndActors(movieId)


}