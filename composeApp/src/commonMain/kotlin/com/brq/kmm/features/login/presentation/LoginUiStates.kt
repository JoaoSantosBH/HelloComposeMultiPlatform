package com.brq.kmm.features.login.presentation

data class LoginUiStates(
    val isSuccessLogin :Boolean = false,
    val allFieldsAreFilled:Boolean = false,
    val name:String = "",
    val pass:String = "",
    val isNameError:Boolean = false,
    val nameErrorHint : String = "Digite seu nome",
    val isPassError:Boolean = false,
    val passErrorHint : String = "A senha deve conter mais de 4 digitos",
    var fakePass:String = "abc123"
) {
    companion object {
        val Empty = LoginUiStates()
    }
}