package com.brq.kmm.core.data.remote.client

import HelloComposeMultiPlatform.composeApp.BuildConfig
import com.brq.kmm.core.data.NetworkUtils.Companion.BASE_URL
import com.brq.kmm.core.data.NetworkUtils.Companion.MOVIES_POPULAR
import com.brq.kmm.core.data.NetworkUtils.Companion.PARAM_KTOR_CLIENT
import com.brq.kmm.core.data.NetworkUtils.Companion.PARAM_LANGUAGE
import com.brq.kmm.core.data.NetworkUtils.Companion.PARAM_PAGES_COUNT
import com.brq.kmm.core.data.NetworkUtils.Companion.PARAM_TOKEN_PREFIX
import com.brq.kmm.core.data.NetworkUtils.Companion.PARAM_TYPE
import com.brq.kmm.core.data.NetworkUtils.Companion.PORTUGUESE_LANGUAGE
import com.brq.kmm.core.domain.ApiError
import com.brq.kmm.core.domain.ApiException
import com.brq.kmm.core.domain.Services
import com.brq.kmm.features.home.data.remote.MovieResponse
import com.brq.kmm.features.home.data.remote.MoviesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders
import okio.IOException

class KtorClient(
    private val client: HttpClient
) : Services {
    override suspend fun getPopularMoviesList(): List<MovieResponse> {

        val result = try {
            client.get(BASE_URL + MOVIES_POPULAR ) {
                url {
                    parameters.append(PARAM_LANGUAGE, PORTUGUESE_LANGUAGE)
                    parameters.append(PARAM_PAGES_COUNT, 1.toString())
                }
                headers {
                    append(HttpHeaders.Accept, PARAM_TYPE)
                    append(HttpHeaders.Authorization, PARAM_TOKEN_PREFIX + BuildConfig.API_TOKEN)
                    append(HttpHeaders.UserAgent, PARAM_KTOR_CLIENT)
                }
            }
        } catch (e: IOException) {
            throw ApiException(ApiError.SERVICE_UNAVAILABLE)
        }

        when(result.status.value){
            in 200..299 -> Unit
            500 -> throw ApiException(ApiError.SERVER_ERROR)
            in 400..499 -> throw ApiException(ApiError.CLIENT_ERROR)
            else -> throw ApiException(ApiError.UNKNOWN_ERROR)
        }

        return try {
            result.body<MoviesResponse>().results
        } catch(e: Exception) {
            throw ApiException(ApiError.SERVER_ERROR)
        }
    }
}