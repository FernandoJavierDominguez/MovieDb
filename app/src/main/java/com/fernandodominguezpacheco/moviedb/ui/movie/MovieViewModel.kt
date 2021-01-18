package com.fernandodominguezpacheco.moviedb.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import kotlinx.coroutines.launch

class MovieViewModel @ViewModelInject constructor(
    private val getAllMovies: GetAllMovies,
    private val movieRepository: MovieRepository
) : ViewModel() {

    val movieItems = getAllMovies.invoke().asLiveData()

    init {
        viewModelScope.launch {
           //movieRepository.addMoviesWithActorsAndGenres(1)
            movieRepository.addMovies(1)
        }
    }

}