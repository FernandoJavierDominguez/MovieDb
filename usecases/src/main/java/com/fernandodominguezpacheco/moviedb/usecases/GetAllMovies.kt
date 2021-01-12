package com.fernandodominguezpacheco.moviedb.usecases

import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.domain.Movie
import kotlinx.coroutines.flow.Flow

class GetAllMovies(private val movieRepository: MovieRepository) {

    fun invoke() : Flow<List<Movie>> = movieRepository.getAllMovies()

}