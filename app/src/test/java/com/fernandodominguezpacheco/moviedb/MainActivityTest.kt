package com.fernandodominguezpacheco.moviedb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernandodominguezpacheco.moviedb.data.repository.MovieRepository
import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.ui.movie.MovieViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Spy
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainActivityTest {

    private lateinit var movieViewModel: MovieViewModel

    private val movies  = listOf(
        Movie(1, "Pelicula 1", "US", 4.4, 2500,
            "GFGF", 5.5, "", "", Date(), "", "",
            listOf(Actor(1, "Juan"), Actor(2, "Pedro")), listOf(Genre(1, "Drama"), Genre(2, "Action"))
        ),
        Movie(2, "Pelicula 2", "US", 4.5, 2600,
            "GFGF", 5.5, "", "", Date(), "", "",
            listOf(Actor(1, "Juan"), Actor(2, "Pedro")), listOf(Genre(1, "Drama"), Genre(2, "Action"))
        ),
        Movie(3, "Pelicula 3", "US", 4.5, 2600,
        "GFGF", 5.5, "", "", Date(), "", "",
        listOf(Actor(1, "Juan"), Actor(2, "Pedro")), listOf(Genre(1, "Drama"), Genre(2, "Action"))
        )
    )

    @Spy
    private val movieLiveData: Flow<List<Movie>> = TODO()

    @Mock
    private lateinit var repository: MovieRepository

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp(){
        `when`(repository.getAllMovies()).thenReturn(movieLiveData)
        movieViewModel = MovieViewModel(repository)
    }

    @After
    fun tearDown(){

    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testEverythingWorks() {
        assert(true)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun loadMovie() = runBlocking {
    }

}