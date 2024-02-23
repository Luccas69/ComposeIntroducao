package com.example.composeintroducao

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeintroducao.ui.InicioScreen
import com.example.composeintroducao.ui.LoginScreen
import com.example.composeintroducao.ui.MinhaContaScreen
import com.example.composeintroducao.ui.theme.ComposeIntroducaoTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroducaoTheme {
                val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "inicio"
                    ) {
                        composable("inicio") {
                            InicioScreen(navController)
                        }
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("minha-conta") {
                            MinhaContaScreen(navController)
                        }
                    }
                }
            }
        }
    }

@Composable
fun Greeting() {
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeIntroducaoTheme {
            Greeting()
    }
}