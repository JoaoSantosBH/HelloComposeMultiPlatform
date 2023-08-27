package com.brq.kmm.core.domain

import com.brq.kmm.features.details.data.remote.MovieDetailResponse
import com.brq.kmm.features.home.data.remote.MovieResponse

interface Services {

    suspend fun getPopularMoviesList() : List<MovieResponse>
    suspend fun getMovieDetails(movieId: Int): MovieDetailResponse

}