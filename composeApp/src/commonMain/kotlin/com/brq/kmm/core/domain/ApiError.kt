package com.brq.kmm.core.domain

enum class ApiError {
    SERVICE_UNAVAILABLE,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR
}

class ApiException(val error: ApiError): Exception(
     "An error occurred when fetching daata: $error"
)