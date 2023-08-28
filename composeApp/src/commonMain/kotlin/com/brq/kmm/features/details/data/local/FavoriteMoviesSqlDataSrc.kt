package com.brq.kmm.features.details.data.local

import app.cash.sqldelight.db.SqlDriver
import com.brq.kmm.database.TmdbDatabase
import com.brq.kmm.features.details.domain.FavoriteMoviesDataSource

class FavoriteMoviesSqlDataSrc(
    sqlDriver: SqlDriver
) : FavoriteMoviesDataSource {

    private val db: TmdbDatabase = TmdbDatabase(sqlDriver)
    private val queries = db.tmdbDatabaseQueries
    override fun getFavoriteMovie(movieId: String): FavoriteMovieModel {
        val result = queries.getFavoriteMovie(movieId)
            .executeAsOneOrNull()
        return result?.toDomain() ?: FavoriteMovieModel()
    }

    override fun insertFavoriteMovie(movie: FavoriteMovieModel) {
        val tmp = movie.toLocal()
       queries.insertFavoriteMovieEntity(
           movieId = tmp.movieId,
           movieName = tmp.movieName,
       )
    }

    override fun removeFavoriteMovie(movieId: String) {
        queries.removeFavoriteMovie(movieId)
    }

    override fun checkIfIsAFavoriteMovie(movieId: String): Boolean {
        val result = queries.getFavoriteMovie(movieId).executeAsOneOrNull();
        return result != null
    }

    override fun getFavoriteMoviesList(): List<Int> {
        val result = queries.getFavoriteMoviesList().executeAsList()
        return  result.map { it.movieId.toInt() }
    }


}