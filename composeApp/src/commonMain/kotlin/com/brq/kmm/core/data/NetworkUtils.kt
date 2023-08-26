package com.brq.kmm.core.data

class NetworkUtils {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org"
        const val MOVIES_POPULAR = "/3/movie/popular"
        const val MOVIE_DETAILS = "3/movie/{movie_id}"
        const val PORTUGUESE_LANGUAGE = "pt-BR"
        const val DEFAULT_NUMBER_PAGES = 1
        const val PATH_PREFIX_URL = "https://image.tmdb.org/t/p/w300/"
        const val FILM_ID = "filmId"
        const val FILM_ID_ARG = "/{filmId}"
        const val PARAM_LANGUAGE = "language"
        const val PARAM_PAGES_COUNT = "page"
    }
}