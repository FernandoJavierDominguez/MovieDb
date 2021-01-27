package com.fernandodominguezpacheco.moviedb.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.ActorRepository
import com.fernandodominguezpacheco.moviedb.data.repository.GenreRepository
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.utils.NetworkUtils
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject  constructor(
    private val actorRepository: ActorRepository,
    private val genreRepository: GenreRepository,
    movieRepository: MovieRepository,
    private val  networkUtils: NetworkUtils
) : ViewModel() {

    var movieId = 0
    val movieItem = movieRepository.getAllMovies().asLiveData()


    fun addActorsByMovie(movie: Movie){
        viewModelScope.launch {
            if(networkUtils.isInternetAvailable()) {
                actorRepository.addActorsByMovie(movie.id)
            }
        }

    }
    fun addGenresByMovie(movie: Movie){
        viewModelScope.launch {
            if(networkUtils.isInternetAvailable()) {
                genreRepository.addGenreByMovie(movie.id)
            }
        }
    }


}