package com.example.composeintroducao.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeintroducao.datastore.AppDataStore
import com.example.composeintroducao.datastore.AppDataStoreKeys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.prefs.Preferences
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val appDataStore: AppDataStore
): ViewModel() {
    val autenticado = mutableStateOf(false)

    fun login (
        user: String,
        senha: String,
        onSucess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        if(user.isNullOrEmpty()) {
            onError("Informe o usuário")
            return
        }

        if (senha.isEmpty()) {
            onError("Informe a senha")
            return
        }

        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, true).apply {
                onSucess()
            }
        }
    }

    fun logout(){
        viewModelScope.launch {
            appDataStore.putBoolean(AppDataStoreKeys.AUTENTICADO, false)


        }
    }
}