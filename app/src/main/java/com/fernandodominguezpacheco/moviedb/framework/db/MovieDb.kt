package com.fernandodominguezpacheco.moviedb.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Actor::class, Movie::class, Genre::class, MovieActor::class, MovieGenre::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class MovieDb : RoomDatabase() {

    abstract fun actorDao(): ActorDao

    abstract fun movieDao(): MovieDao

    abstract fun genreDao(): GenreDao

    abstract fun movieActor(): MovieActorDao

    abstract fun movieGenre(): MovieGenreDao

}