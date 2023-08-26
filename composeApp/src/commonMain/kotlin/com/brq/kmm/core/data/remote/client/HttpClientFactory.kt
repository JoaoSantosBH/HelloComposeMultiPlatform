package com.brq.kmm.core.data.remote.client

import io.ktor.client.HttpClient

expect class HttpClientFactory() {
    fun create() : HttpClient
}