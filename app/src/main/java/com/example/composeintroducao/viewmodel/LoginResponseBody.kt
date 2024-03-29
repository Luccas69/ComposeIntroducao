package com.example.composeintroducao.viewmodel

import com.example.composeintroducao.api.model.Usuario

data class LoginResponseBody (
    var token: String = "",
    var usuario: Usuario
)