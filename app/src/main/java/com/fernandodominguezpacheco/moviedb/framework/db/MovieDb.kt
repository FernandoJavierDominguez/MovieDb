package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Database
import androidx.room.TypeConverters

@Database(
    entities = [Actor::class, Movie::class, Genre::class, MovieActor::class, MovieGenre::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDb {

}