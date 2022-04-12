package com.dimaszulfa.movie.data.network

import com.dimaszulfa.movie.data.remote.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") apikey: String) : MovieResponse
}