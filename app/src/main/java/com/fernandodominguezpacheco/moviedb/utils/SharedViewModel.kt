package com.fernandodominguezpacheco.moviedb.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.Movie

class SharedViewModel: ViewModel() {

    private val selectedMovie = MutableLiveData<Movie>()
    private val selectedActor = MutableLiveData<Actor>()

    fun selectMovie(movie: Movie){
        selectedMovie.value = movie
    }
    fun getSelectedMovie() : LiveData<Movie>{
        return selectedMovie
    }
    fun selectActor(actor: Actor){
        selectedActor.value = actor
    }
    fun getSelectedActor() : LiveData<Actor>{
        return selectedActor
    }



}