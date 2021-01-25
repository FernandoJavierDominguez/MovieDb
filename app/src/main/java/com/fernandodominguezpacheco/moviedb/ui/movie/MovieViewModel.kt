package com.fernandodominguezpacheco.moviedb.ui.movie

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import java.util.*

class MovieViewModel @ViewModelInject constructor(
    private val getAllMovies: GetAllMovies,
    private val movieRepository: MovieRepository
) : ViewModel() {

    //val movieItems = getAllMovies.invoke().asLiveData()
    val text = MutableStateFlow("")

    private val movieQuery = text.flatMapLatest {
        movieRepository.getMoviesBySearch(it)
    }

    val movieItems = movieQuery.asLiveData()

    init {
        viewModelScope.launch {
           //movieRepository.addMoviesWithActorsAndGenres(1)
            movieRepository.addMovies(1)
        }
    }

}