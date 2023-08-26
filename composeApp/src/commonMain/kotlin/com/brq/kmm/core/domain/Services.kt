package com.brq.kmm.core.domain

import com.brq.kmm.features.home.data.remote.MovieResponse

interface Services {

    suspend fun getPopularMoviesList() : List<MovieResponse>

}