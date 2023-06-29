package com.brq.kmm.features.login

sealed class LoginEvent {
    data class ValidateNameField(val name: String) : LoginEvent()
    data class ValidatePassField(val pass: String) : LoginEvent()
    object ValidateLogin : LoginEvent()
}