package com.fernandodominguezpacheco.moviedb.framework.server

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiService {

    //https://api.themoviedb.org/3/movie/75400/credits?api_key=6ed8cc899733fb81c7e240e5a3b86f59&language=en-US
    @GET("movie/{movieId}/credits")
    suspend fun getActorsByMovie(
        @Path("movieId") movieId: Int,
        @Query("api_key") api_key: String,
    ) : Cast

    //https://api.themoviedb.org/3/movie/75400/credits?api_key=6ed8cc899733fb81c7e240e5a3b86f59&language=en-US
    @GET("movie/{movieId}")
    suspend fun getGenresByMovie(
        @Path("movieId") movieId: Int,
        @Query("api_key") api_key: String,
    ) : Movie

    //https://api.themoviedb.org/3/movie/popular?api_key=7d51874568317dfd0c91db399be2bdec&language=en-US&page=1
    @GET("movie/popular")
    suspend fun getMovies(
        //@Path("sort_criteria") sort_criteria: String,
        @Query("api_key") api_key: String?,
        @Query("language") language: String? = "en-US",
        @Query("page") page: Int? = 1,
    ) : List<Movie>
}