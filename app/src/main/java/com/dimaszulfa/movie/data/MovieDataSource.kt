package com.dimaszulfa.movie.data

import com.dimaszulfa.movie.data.network.ApiService
import com.dimaszulfa.movie.domain.Movie

class MovieDataSource(private val remote: ApiService) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {
        return remote.getMovies("2a40aac3fb77405dad9221d6f249882c").getMovies()
    }
}