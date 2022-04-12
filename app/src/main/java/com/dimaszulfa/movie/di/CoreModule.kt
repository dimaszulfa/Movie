package com.dimaszulfa.movie.di

import com.dimaszulfa.movie.data.MovieDataSource
import com.dimaszulfa.movie.data.MovieRepository
import com.dimaszulfa.movie.data.network.ApiConfig
import com.dimaszulfa.movie.data.network.ApiService
import com.dimaszulfa.movie.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

val networkModule = module {
    single<ApiService> { ApiConfig.getApiServices() }
    single<MovieRepository>{MovieDataSource(get())}
}

