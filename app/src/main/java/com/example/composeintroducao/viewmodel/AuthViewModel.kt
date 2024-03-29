package com.example.composeintroducao.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeintroducao.datastore.AppDataStore
import com.example.composeintroducao.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.prefs.Preferences
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
) : ViewModel() {

    val loading = mutableStateOf(false)
    val autenticado = mutableStateOf(false)


    fun login(
        user: String,
        senha: String,
        onSucess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        if (user.isNullOrEmpty()) {
            onError("Informe o usuário")
            return
        }

        if (senha.isEmpty()) {
            onError("Informe a senha")
            return
        }

        loading.value = true

        val requestBody = LoginRequestBody()
        requestBody.email = user
        requestBody.senha = senha

        val retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("https://api-estudos.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val endpoint = retrofit.create(Endpoint::class.java)

        viewModelScope.launch {
            val callback = endpoint.login(requestBody)

            callback.enqueue(object : Callback<LoginResponseBody> {
                override fun onFailure(call: Call<LoginResponseBody>, t: Throwable) {
                    if (t.message.isNullOrBlank()) {
                        onError("No fall message avaliable")
                    } else {
                        onError(t.message!!)
                    }
                }

                override fun onResponse(call: Call<LoginResponseBody>, response: Response<LoginResponseBody>){
                    onSucess()
                    response.body()?.let { responseBody ->
                        print(responseBody.token)
                    }
                }

            })
        }
    }

    fun logout(onSuccess: () -> Unit) {

        loading.value = true

        viewModelScope.launch {
            delay(4000)
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, false).apply {
                onSuccess()
            }
        }
    }
}
    interface Endpoint {
        @POST("/login")
        fun login(@Body requestBody: LoginRequestBody): Call<LoginResponseBody>
    }
