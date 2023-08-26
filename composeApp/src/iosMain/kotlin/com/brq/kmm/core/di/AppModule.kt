package com.brq.kmm.core.di

import com.brq.kmm.core.data.remote.client.HttpClientFactory
import com.brq.kmm.core.data.remote.client.KtorClient
import com.brq.kmm.core.domain.Services
import org.koin.dsl.module

class AppModule {

    val iosModule = module {
        single { HttpClientFactory().create() }
        factory<Services> { KtorClient(get()) }
    }

    val movies: KtorClient by lazy {
        KtorClient(
            HttpClientFactory().create()
        )
    }

}