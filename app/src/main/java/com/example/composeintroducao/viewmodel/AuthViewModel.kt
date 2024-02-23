package com.example.composeintroducao.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel: ViewModel() {
    val autenticado = mutableStateOf(false)

    fun login (
        user: String,
        senha: String,
        onSucess: () -> Unit,
        onError: (String) -> Unit
    ) {
        if(user == "luccas" && senha == "8426") {
            onSucess()
        } else {
            onError("Usuário ou senha inválido")
        }
    }
}