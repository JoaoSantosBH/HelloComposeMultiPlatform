package com.brq.kmm.features.home.data.remote

import com.brq.kmm.features.home.domain.MovieModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponse(
    @SerialName("page") val page: Int?,
    @SerialName("results") val results: List<MovieResponse>,
    @SerialName("total_pages") val totalPages: Int?,
    @SerialName("total_results") val totalResults: Int?
) {
    companion object {


        val fakeResults = listOf(
            MovieResponse(
                adult = false,
                backdropPath = "/nDxJJyA5giRhXx96q1sWbOUjMBI.jpg",
                listOf(28, 35, 14),
                594767,
                originalLanguage = "en",
                originalTitle = "Shazam! Fury of the Gods",
                overview = "Billy Batson and his foster siblings, who transform into superheroes by saying \\\"Shazam!\\\", are forced to get back into action and fight the Daughters of Atlas, who they must stop from using a weapon that could destroy the world.",
                4274.865,
                posterPath = "/2VK4d3mqqTc7LVZLnLPeRiPaJ71.jpg",
                releaseDate = "2023-03-15",
                title = "Shazam! Fury of the Gods",
                false,
                6.9,
                1231
            ),
            MovieResponse(
                adult = false,
                backdropPath = "/gMJngTNfaqCSCqGD4y8lVMZXKDn.jpg",
                listOf(28, 12, 878),
                640146,
                originalLanguage = "en",
                originalTitle = "Ant-Man and the Wasp: Quantumania",
                overview = "Super-Hero partners Scott Lang and Hope van Dyne, along with with Hope's parents Janet van Dyne and Hank Pym, and Scott's daughter Cassie Lang, find themselves exploring the Quantum Realm, interacting with strange new creatures and embarking on an adventure that will push them beyond the limits of what they thought possible.",
                8567.865,
                posterPath = "/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
                releaseDate = "2023-02-15",
                title = "Ant-Man and the Wasp: Quantumania",
                false,
                6.5,
                1886
            )
        )
        val FakeResponse = MoviesResponse(
            page = 1,
            fakeResults,
            1,
            1
        )
    }
}
@Serializable
data class MovieResponse(
    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("genre_ids") val genreIds: List<Int>?,
    @SerialName("id") val id: Int?,
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_title") val originalTitle: String?,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double?,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("release_date") val releaseDate: String?,
    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val voteAverage: Double?,
    @SerialName("vote_count") val voteCount: Int?
){
    companion object {
        fun List<MovieResponse>.toDomain() = this.map { it.toDomain() }

        private fun MovieResponse.toDomain() = MovieModel(
            adult = this.adult,
            backdropPath= this.backdropPath,
            genreIds= this.genreIds,
            id= this.id,
            originalLanguage= this.originalLanguage,
            originalTitle= this.originalTitle,
            overview= this.overview,
            popularity= this.popularity,
            posterPath= this.posterPath,
            releaseDate= this.releaseDate.toDateFormat(),
            title= this.title,
            video= this.video,
            voteAverage= this.voteAverage,
            voteCount= this.voteCount
        )
    }
}

fun String?.toDateFormat(): String {
 return "123"
}
