package com.brq.kmm.core.di

import com.brq.kmm.core.data.remote.client.HttpClientFactory
import com.brq.kmm.core.data.remote.client.KtorClientImpl
import com.brq.kmm.core.domain.Services
import org.koin.dsl.module

class AppModule {

    val iosModule = module {
        single { HttpClientFactory().create() }
        factory<Services> { KtorClientImpl(get()) }
    }

    val movies: KtorClientImpl by lazy {
        KtorClientImpl(
            HttpClientFactory().create()
        )
    }

}