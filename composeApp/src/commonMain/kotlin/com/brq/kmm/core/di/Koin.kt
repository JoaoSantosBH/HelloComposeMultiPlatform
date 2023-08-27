package com.brq.kmm.core.di

import com.brq.kmm.core.data.remote.client.HttpClientFactory
import com.brq.kmm.core.data.remote.client.KtorClientImpl
import com.brq.kmm.core.domain.Services
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(){
    startKoin {
        modules(iosModule)
    }
}

val iosModule = module {
    single { HttpClientFactory().create() }
    factory<Services> { KtorClientImpl(get()) }
}