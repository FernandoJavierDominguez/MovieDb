package com.fernandodominguezpacheco.moviedb.framework

import com.fernandodominguezpacheco.moviedb.domain.Actor
import com.fernandodominguezpacheco.moviedb.domain.Genre
import com.fernandodominguezpacheco.moviedb.domain.Movie
import com.fernandodominguezpacheco.moviedb.framework.db.Actor as RoomActor
import com.fernandodominguezpacheco.moviedb.framework.db.Genre as RoomGenre
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

//Actor
fun RoomActor.toActor(): Actor = Actor(
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

