package com.brq.kmm.features.login.presentation

sealed class LoginEvent {
    data class ValidateNameField(val name: String) : LoginEvent()
    data class ValidatePassField(val pass: String) : LoginEvent()
    object ValidateLogin : LoginEvent()
}