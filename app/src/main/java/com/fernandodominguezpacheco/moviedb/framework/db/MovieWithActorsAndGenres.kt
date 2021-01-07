package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class MovieWithActorsAndGenres(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "actorId",
        associateBy = Junction(MovieActor::class)
    )
    val actors: List<Actor>,
    @Relation(
        parentColumn = "movieId",
        entityColumn = "genreId",
        associateBy = Junction(MovieGenre::class)
    )
    val genres: List<Genre>

) {
}