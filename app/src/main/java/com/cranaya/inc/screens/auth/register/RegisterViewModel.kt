package com.cranaya.inc.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())

    var errorMessage by mutableStateOf("")
        private set

    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onLastnameInput(input: String) {
        state = state.copy(lastname = input)
    }

    fun onEmailInput(input: String) {
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String) {
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String) {
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String) {
        state = state.copy(confirmPassword = input)
    }

    fun validateForm() = viewModelScope.launch {

        if (state.name == "") {
            errorMessage = "Ingrese el nombre"
        }
        else if (state.lastname == "") {
            errorMessage = "Ingrese el apellido"
        }
        else if (state.phone == "") {
            errorMessage = "Ingrese el telefono"
        }
        else if (state.email == "") {
            errorMessage = "Ingrese el email"
        }
        else if (state.password == "") {
            errorMessage = "Ingrese la contraseña"
        }
        else if (state.confirmPassword == "") {
            errorMessage = "Debes confirmar la contraseña"
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
        }
        else if (state.confirmPassword != state.password) {
            errorMessage = "Las contraseña no coinciden"
        }

        delay(3000)

        errorMessage = ""
    }
}