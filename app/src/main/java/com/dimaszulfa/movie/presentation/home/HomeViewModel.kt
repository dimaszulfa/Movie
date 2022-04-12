package com.dimaszulfa.movie.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimaszulfa.movie.data.MovieRepository
import com.dimaszulfa.movie.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private var repository: MovieRepository): ViewModel() {

    private var _movies = MutableLiveData<List<Movie>>()
    val movies get() = _movies

    fun getMovieData(){
        viewModelScope.launch(Dispatchers.IO) {
            val getData = repository.getMovies()
            _movies.postValue(getData)
        }
    }

}