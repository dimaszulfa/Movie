package com.dimaszulfa.movie.data.remote

import com.dimaszulfa.movie.domain.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<Results>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
){
	fun getMovies(): List<Movie> {
		return results?.map {
			it.toMovie()
		}.orEmpty()
	}
}
