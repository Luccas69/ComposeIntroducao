package com.example.composeintroducao.api.request

import com.example.composeintroducao.api.model.Usuario

data class LoginRequestBody (
    var email: String = "",
    var usuario: Usuario
)