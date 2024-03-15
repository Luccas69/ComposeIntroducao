package com.example.composeintroducao.api.response

import com.example.composeintroducao.api.model.Usuario

data class UsuariosResponseBody (
    var docs: List<Usuario>
)
