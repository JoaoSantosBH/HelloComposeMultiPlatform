package com.brq.kmm.core.di

import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(iosModule)
    }
}


