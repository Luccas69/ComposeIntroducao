package com.example.composeintroducao.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeintroducao.R
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeintroducao.ui.theme.ComposeIntroducaoTheme
import com.example.composeintroducao.viewmodel.AuthViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {

    var user by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    val viewModel = hiltViewModel<AuthViewModel>()


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.ifro_campus_vertical),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .size(150.dp)
            )

            if (error.isNotBlank()) {
                Text(error)
            }

            OutlinedTextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Usuário") }
            )

            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation(),
            )

            Button(
                onClick = {
                    viewModel.login(
                        user,
                        senha,
                        onSucess = {
                            navController.navigate("minha-conta")

                        },
                        onError = { message ->
                            error = message
                        },
                    )
                },
            ) {
                Text("Entrar")
            }
        }

        if(viewModel.loading.value){
            LoadScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposeIntroducaoTheme {
        LoginScreen(rememberNavController())
    }
}