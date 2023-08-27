package com.brq.kmm.features.details.data.remote

import com.brq.kmm.features.details.domain.BelongsModel
import com.brq.kmm.features.details.domain.GenreModel
import com.brq.kmm.features.details.domain.MovieDetailsModel
import com.brq.kmm.features.details.domain.ProductionCompanyModel
import com.brq.kmm.features.details.domain.ProductionCountryModel
import com.brq.kmm.features.details.domain.SpokenLanguageModel
import com.brq.kmm.features.home.data.remote.toDateFormat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailResponse(
    @SerialName("adult") val adult: Boolean?,
    @SerialName("backdrop_path") val backdropPath: String?,
    @SerialName("belongs_to_collection") val belongsToCollection: BelongsToCollection? = null,
    @SerialName("budget") val budget: Int?,
    @SerialName("genres") val genres: List<Genre>?,
    @SerialName("homepage") val homepage: String?,
    @SerialName("id") val id: Int?,
    @SerialName("imdb_id") val imdbId: String?,
    @SerialName("original_language") val originalLanguage: String?,
    @SerialName("original_title") val originalTitle: String?,
    @SerialName("overview") val overview: String?,
    @SerialName("popularity") val popularity: Double?,
    @SerialName("poster_path") val posterPath: String?,
    @SerialName("production_companies") val productionCompanies: List<ProductionCompany>?,
    @SerialName("production_countries") val productionCountries: List<ProductionCountry>?,
    @SerialName("release_date") val releaseDate: String?,
    @SerialName("revenue") val revenue: Long?,
    @SerialName("runtime") val runtime: Int?,
    @SerialName("spoken_languages") val spokenLanguages: List<SpokenLanguage>?,
    @SerialName("status") val status: String?,
    @SerialName("tagline") val tagline: String?,
    @SerialName("title") val title: String?,
    @SerialName("video") val video: Boolean?,
    @SerialName("vote_average") val voteAverage: Double?,
    @SerialName("vote_count") val voteCount: Int?
) {
    companion object {
        fun MovieDetailResponse.toDomain() = MovieDetailsModel(
            adult = this.adult ?: false,
            backdropPath = this.backdropPath ?: "",
            belongsCollection = this.belongsToCollection?.toBelongDomain() ?: BelongsModel.EMPTY,
            budget = this.budget ?: -1,
            genres = this.genres?.toGenreDomain() ?: listOf(),
            homepage = this.homepage ?: "",
            id = this.id ?: -1,
            imdbId = this.imdbId ?: "",
            originalLanguage = this.originalLanguage ?: "",
            originalTitle = this.originalTitle ?: "",
            overview = this.overview ?: "",
            popularity = this.popularity ?: 0.0,
            posterPath = this.posterPath ?: "",
            productionCompanies = this.productionCompanies?.toProductionCompanyDomain() ?: listOf(),
            productionCountries = this.productionCountries?.toProductionCountryDomain() ?: listOf(),
            release_date = this.releaseDate.toDateFormat() ?: "",
            revenue = this.revenue ?: -1L,
            runtime = this.runtime ?: -1,
            spokenLanguages = this.spokenLanguages?.toSpokenLanguageDomain() ?: listOf(),
            status = this.status ?: "",
            tagline = this.tagline ?: "",
            title = this.title ?: "",
            video = this.video ?: false,
            voteAverage = this.voteAverage ?: 0.0,
            voteCount = this.voteCount ?: -1
        )
    }

    fun List<Genre>.toGenreDomain() =
        this.map { it.toDomain() }

    private fun Genre.toDomain() = GenreModel(
        id = this.id ?: -1,
        name = this.name ?: ""
    )

    fun List<ProductionCompany>.toProductionCompanyDomain() = this.map { it.toDomain() }
    private fun ProductionCompany.toDomain() = ProductionCompanyModel(
        id = this.id ?: -1,
        logoPath = this.logoPath ?: "",
        name = this.name ?: "",
        originCountry = this.originCountry ?: ""
    )

    fun BelongsToCollection.toBelongDomain() = BelongsModel(
        backdropPath = this.backdropPath ?: "",
        id = this.id ?: -1,
        name = this.name ?: "",
        postePath = this.posterPath ?: ""
    )

    fun List<ProductionCountry>.toProductionCountryDomain() = this.map { it.toDomain() }

    private fun ProductionCountry.toDomain() = ProductionCountryModel(
        iso_3166_1 = this.iso31661 ?: "",
        name = this.name ?: ""
    )

    fun List<SpokenLanguage>.toSpokenLanguageDomain() = this.map { it.toDomain() }
    private fun SpokenLanguage.toDomain() = SpokenLanguageModel(
        englishName = this.englishName ?: "",
        iso_639_1 = this.iso6391 ?: "",
        name = this.name ?: ""

    )
}

@Serializable

data class Genre(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?
)

@Serializable

data class ProductionCompany(
    @SerialName("id") val id: Int?,
    @SerialName("logo_path") val logoPath: String?,
    @SerialName("name") val name: String?,
    @SerialName("origin_country") val originCountry: String?
)

@Serializable

data class ProductionCountry(
    @SerialName("iso_3166_1") val iso31661: String?,
    @SerialName("name") val name: String?
)

@Serializable

data class SpokenLanguage(
    @SerialName("english_name") val englishName: String?,
    @SerialName("iso_639_1") val iso6391: String?,
    @SerialName("name") val name: String?
)

@Serializable

data class BelongsToCollection(
    @SerialName("backdrop_path") val backdropPath: String? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("poster_path") val posterPath: String? = null
)