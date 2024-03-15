package com.example.composeintroducao.api.model

data class Usuario (
    var id: String = "",
    var nome: String = "",
    var email: String = "",
    var foto: String? = null
)