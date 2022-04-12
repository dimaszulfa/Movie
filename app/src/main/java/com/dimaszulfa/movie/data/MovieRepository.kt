package com.dimaszulfa.movie.data

import com.dimaszulfa.movie.domain.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>

}