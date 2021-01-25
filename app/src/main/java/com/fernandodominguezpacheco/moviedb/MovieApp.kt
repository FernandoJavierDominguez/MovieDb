package com.fernandodominguezpacheco.moviedb

import android.app.Application
import com.fernandodominguezpacheco.moviedb.framework.di.*
import com.fernandodominguezpacheco.moviedb.framework.di.ApplicationProviderModule


open class MovieApp : Application() {

    private lateinit var component: MovieDbComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerMovieDbComponent.builder()
            .applicationProviderModule(ApplicationProviderModule(this))
            .build()
    }
    fun getComponent() = component

}