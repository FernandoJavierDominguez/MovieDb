package com.fernandodominguezpacheco.moviedb.framework.di

import android.app.Application
import com.fernandodominguezpacheco.moviedb.MainActivity
import com.fernandodominguezpacheco.moviedb.MainActivityModule
import com.fernandodominguezpacheco.moviedb.ui.actor.ActorFragment
import com.fernandodominguezpacheco.moviedb.ui.detail.DetailFragment
import com.fernandodominguezpacheco.moviedb.ui.movie.MovieFragment
import com.fernandodominguezpacheco.moviedb.utils.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainActivityModule::class, AppModule::class, DataModule::class, ViewModelModule::class, ApplicationProviderModule::class])
interface MovieDbComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(movieFragment: MovieFragment)
    fun inject(detailFragment: DetailFragment)
    fun inject(actorFragment: ActorFragment)
}