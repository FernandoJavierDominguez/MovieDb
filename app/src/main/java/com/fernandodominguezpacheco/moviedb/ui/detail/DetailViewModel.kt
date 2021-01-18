package com.fernandodominguezpacheco.moviedb.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.moviedb.data.repository.ActorRepository
import com.fernandodominguezpacheco.moviedb.data.repository.GenreRepository
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.usecases.GetAllMovies
import kotlinx.coroutines.launch

class DetailViewModel @ViewModelInject constructor(
    private val actorRepository: ActorRepository,
    private val genreRepository: GenreRepository,
    private val movieRepository: MovieRepository
) : ViewModel() {

    var movieId = 0
    /*val actors = actorRepository.getActorsByMovie(movieId).asLiveData()
    val genres = genreRepository.getGenresByMovie(movieId).asLiveData()*/
    //val movieItem = movieRepository.getMovieById(movieId).asLiveData()
    val movieItem = movieRepository.getAllMovies().asLiveData()


    fun setId(id: Int){
        movieId = id
    }


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