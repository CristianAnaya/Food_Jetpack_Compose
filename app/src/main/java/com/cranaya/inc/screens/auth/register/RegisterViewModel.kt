package com.cranaya.inc.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cranaya.data.auth.model.dto.AuthResponse
import com.cranaya.domain.auth.model.User
import com.cranaya.domain.auth.usecase.AuthUseCase
import com.cranaya.domain.shared.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set
    var registerResponse by mutableStateOf<Resource<User>?>(null)
        private set
    var errorMessage by mutableStateOf("")

    fun register() = viewModelScope.launch {
        if (isValidForm()) {
            val user = User(
                name = state.name,
                lastname = state.lastname,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user = user)
            registerResponse = result
        }
    }
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

    fun isValidForm(): Boolean {

        if (state.name == "") {
            errorMessage = "Ingrese el nombre"
            return false
        }
        else if (state.lastname == "") {
            errorMessage = "Ingrese el apellido"
            return false
        }
        else if (state.phone == "") {
            errorMessage = "Ingrese el telefono"
            return false
        }
        else if (state.email == "") {
            errorMessage = "Ingrese el email"
            return false
        }
        else if (state.password == "") {
            errorMessage = "Ingrese la contraseña"
            return false
        }
        else if (state.confirmPassword == "") {
            errorMessage = "Debes confirmar la contraseña"
            return false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            errorMessage = "El email no es valido"
            return false
        }
        else if (state.password.length < 6) {
            errorMessage = "La contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if (state.confirmPassword != state.password) {
            errorMessage = "Las contraseña no coinciden"
            return false
        }

        return true
    }
}