package com.brq.kmm.features.details.domain

data class MovieDetailsModel(
    val adult: Boolean,
    val backdropPath: String,
    val belongsCollection: BelongsModel,
    val budget: Int,
    val genres: List<GenreModel>,
    val homepage: String,
    val id: Int,
    val imdbId: String,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val productionCompanies: List<ProductionCompanyModel>,
    val productionCountries: List<ProductionCountryModel>,
    val release_date: String,
    val revenue: Long,
    val runtime: Int,
    val spokenLanguages: List<SpokenLanguageModel>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
) {
    companion object {
        val EMPTY = MovieDetailsModel(
            adult = false,
            backdropPath = "",
            belongsCollection = BelongsModel.EMPTY,
            budget = 0,
            genres = listOf(),
            homepage = "",
            id = -1,
            imdbId = "",
            originalLanguage = "",
            originalTitle = "",
            overview = "",
            popularity = 0.0,
            posterPath = "",
            productionCompanies = listOf(),
            productionCountries = listOf(),
            release_date = "27/02/2022",
            revenue = -1,
            runtime = -1,
            spokenLanguages = listOf(),
            status = "",
            tagline = "",
            title = "",
            video = false,
            voteAverage = 0.0,
            voteCount = -1
        )
    }
}

data class GenreModel(
    val id: Int,
    val name: String
)

data class ProductionCompanyModel(
    val id: Int,
    val logoPath: String,
    val name: String,
    val originCountry: String
) {
    companion object {
        val EMPTY = ProductionCompanyModel(
            id = -1,
            logoPath = "",
            name = "",
            originCountry = "",
        )
    }
}

data class ProductionCountryModel(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguageModel(
    val englishName: String,
    val iso_639_1: String,
    val name: String
)

data class BelongsModel(
    val backdropPath: String,
    val id: Int,
    val name: String,
    val postePath: String
) {
    companion object {
        val EMPTY = BelongsModel( "", -1, "", "")
    }
}