package com.fernandodominguezpacheco.moviedb.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.ActorRepository
import com.fernandodominguezpacheco.moviedb.data.repository.GenreRepository
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.domain.Movie
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject  constructor(
    private val actorRepository: ActorRepository,
    private val genreRepository: GenreRepository,
    movieRepository: MovieRepository
) : ViewModel() {

    var movieId = 0
    val movieItem = movieRepository.getAllMovies().asLiveData()


    fun addActorsByMovie(movie: Movie){
        viewModelScope.launch {
            actorRepository.addActorsByMovie(movie.id)
        }

    }
    fun addGenresByMovie(movie: Movie){
        viewModelScope.launch {
            genreRepository.addGenreByMovie(movie.id)
        }
    }


}