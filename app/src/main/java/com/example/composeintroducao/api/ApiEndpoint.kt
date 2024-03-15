package com.example.composeintroducao.api

import com.example.composeintroducao.api.request.LoginRequestBody
import com.example.composeintroducao.api.response.LoginResponseBody
import com.example.composeintroducao.api.response.UsuariosResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.GET

interface ApiEndpoint {
    @POST("/login")
    suspend fun login(@Body requestBody: LoginRequestBody) : Response<LoginResponseBody>

    @GET("/usuarios")
    suspend fun usuarios() : Response<UsuariosResponseBody>
}
