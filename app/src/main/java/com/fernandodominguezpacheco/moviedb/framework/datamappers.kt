package com.fernandodominguezpacheco.moviedb.framework


import com.fernandodominguezpacheco.moviedb.domain.*
import com.fernandodominguezpacheco.moviedb.framework.db.Movie as RoomMovie
import com.fernandodominguezpacheco.moviedb.framework.db.Actor as RoomActor
import com.fernandodominguezpacheco.moviedb.framework.db.Genre as RoomGenre
import com.fernandodominguezpacheco.moviedb.framework.db.MovieActor as RoomMovieActor
import com.fernandodominguezpacheco.moviedb.framework.db.MovieGenre as RoomMovieGenre
import com.fernandodominguezpacheco.moviedb.framework.db.MovieWithActorsAndGenres


//Movie
fun MovieWithActorsAndGenres.toMovie() : Movie = Movie(
    movie.id,
    movie.title,
    movie.original_language,
    movie.vote_average,
    movie.vote_count,
    movie.imdbId,
    movie.popularity,
    movie.homepage,
    movie.overview,
    movie.release_date,
    movie.urlImage,
    movie.status,
    actors.map { it.toActor() },
    genres.map { it.toGenre() }
)

fun Movie.toRoomMovie(): RoomMovie = RoomMovie(
    id,
    title,
    original_language,
    vote_average,
    vote_count,
    imdbId,
    popularity,
    homepage,
    overview,
    release_date,
    urlImage,
    status
)

//Actor
fun RoomActor.toActor(): Actor = Actor(
    id,
    name,
    popularity,
    urlImage,
    character
)

fun Actor.toRoomActor(): RoomActor = RoomActor(
    id,
    name,
    popularity,
    urlImage,
    character
)
//Genre
fun RoomGenre.toGenre(): Genre = Genre(
    id,
    name
)
fun Genre.toRoomGenre(): RoomGenre = RoomGenre(
    id,
    name
)

//MovieActor
fun MovieActor.toRoomMovieActor() : RoomMovieActor = RoomMovieActor(
    idMovie,
    idActor
)

//MovieGenre
fun MovieGenre.toRoomMovieGenre() : RoomMovieGenre = RoomMovieGenre(
    idMovie,
    idGenre
)


