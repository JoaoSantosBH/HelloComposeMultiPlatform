package com.brq.kmm.features.login

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenModel: ScreenModel {
    private val _uiState: MutableStateFlow<LoginUiStates> =
        MutableStateFlow(LoginUiStates.Empty)
    var uiSTate: StateFlow<LoginUiStates> = _uiState
    private val pendingActions = MutableSharedFlow<LoginEvent>()

    init { handleEvents() }

    fun onEvent(event: LoginEvent) {
        coroutineScope.launch {
            pendingActions.emit(event)
        }
    }

    private fun handleEvents() {
        coroutineScope.launch {
            pendingActions.collect { event ->
                when (event) {
                    is LoginEvent.ValidateLogin -> validatingLogin()
                    is LoginEvent.ValidateNameField -> validateNameField(event)
                    is LoginEvent.ValidatePassField -> validatePassField(event)
                }
            }
        }
    }

    private fun validatePassField(event: LoginEvent.ValidatePassField) {
        _uiState.update { it.copy(pass = event.pass) }
        if (event.pass.isNotEmpty() && event.pass.length > 4) _uiState.update { it.copy(isPassError = false) }
        else _uiState.update { it.copy(isPassError = true) }
    }

    private fun validateNameField(event: LoginEvent.ValidateNameField) {
        _uiState.value =  _uiState.value.copy(name = event.name)
        if (event.name.isNotEmpty()) _uiState.update { it.copy(isNameError = false) }
        else _uiState.update { it.copy(isNameError = true) }
    }

    private fun validatingLogin() {
        verifyAllFieldsAreFilled()
        if (_uiState.value.pass == uiSTate.value.fakePass &&
            !_uiState.value.isNameError &&
            !_uiState.value.isPassError &&
            _uiState.value.name.isNotEmpty()) {
            _uiState.update { it.copy(isSuccessLogin = true) }
        }
        else _uiState.update { it.copy(isSuccessLogin = false) }
    }

    private fun verifyAllFieldsAreFilled() {
        if (_uiState.value.name.isNotEmpty() && _uiState.value.pass.isNotEmpty()) {
            _uiState.update { it.copy( allFieldsAreFilled = true) }
        } else {
            _uiState.update { it.copy( allFieldsAreFilled = false) }
        }
    }
}