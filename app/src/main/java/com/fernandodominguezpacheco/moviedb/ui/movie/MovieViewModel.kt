package com.fernandodominguezpacheco.moviedb.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import com.fernandodominguezpacheco.moviedb.utils.NetworkUtils
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository,

) : ViewModel() {

    //val movieItems = getAllMovies.invoke().asLiveData()
    val text = MutableStateFlow("")


    @ExperimentalCoroutinesApi
    private val movieQuery = text.flatMapLatest {
        movieRepository.getMoviesBySearch(it)
    }

    @ExperimentalCoroutinesApi
    val movieItems = movieQuery.asLiveData()

    init {
        viewModelScope.launch {
           //movieRepository.addMoviesWithActorsAndGenres(1)
            movieRepository.addMovies(1)
        }
    }

}