package com.fernandodominguezpacheco.moviedb.ui.movie

import androidx.lifecycle.*
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
    private val  networkUtils: NetworkUtils
) : ViewModel() {

    //val movieItems = getAllMovies.invoke().asLiveData()
    val text = MutableStateFlow("")
    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message





    @ExperimentalCoroutinesApi
    private val movieQuery = text.flatMapLatest {
        movieRepository.getMoviesBySearch(it)
    }

    @ExperimentalCoroutinesApi
    val movieItems = movieQuery.asLiveData()

    init {
        viewModelScope.launch {
            if(networkUtils.isInternetAvailable()) {
                movieRepository.addMovies(1)
            }
            else{
                _message.value = "No Internet Avalaible"
            }
        }
    }

}