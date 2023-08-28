package com.brq.kmm

import com.brq.kmm.core.data.local.DatabaseDriverFactory
import com.brq.kmm.core.data.remote.client.HttpClientFactory
import com.brq.kmm.core.data.remote.client.KtorClientImpl
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.details.data.local.FavoriteMoviesSqlDataSrc
import com.brq.kmm.features.details.domain.FavoriteMoviesDataSource
import org.koin.dsl.module

val androidModule = module {
    single { HttpClientFactory().create() }
    factory<Services> { KtorClientImpl(get()) }
    single { DatabaseDriverFactory(get()).create() }
    single<FavoriteMoviesDataSource> { FavoriteMoviesSqlDataSrc(get()) }

}