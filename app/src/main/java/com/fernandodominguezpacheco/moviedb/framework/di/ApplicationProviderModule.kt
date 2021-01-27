package com.fernandodominguezpacheco.moviedb.framework.di

import android.app.Application
import com.fernandodominguezpacheco.moviedb.utils.NetworkUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
internal class ApplicationProviderModule(private val application: Application) {
    @Provides
    @Singleton
    fun application(): Application {
        return application
    }

    @Singleton
    @Provides
    fun providesNetworkConnectivityHelper(): NetworkUtils {
        return NetworkUtils(application.applicationContext)
    }
}