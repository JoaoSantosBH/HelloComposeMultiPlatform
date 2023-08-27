package com.brq.kmm

import com.brq.kmm.core.data.remote.client.HttpClientFactory
import com.brq.kmm.core.data.remote.client.KtorClientImpl
import com.brq.kmm.core.domain.Services
import org.koin.dsl.module

val androidModule = module {
    single { HttpClientFactory().create() }
    factory<Services> { KtorClientImpl(get()) }
}