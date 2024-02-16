package com.example.composeintroducao.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MinhaConta () {

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column (
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Top,
          horizontalAlignment = Alignment.CenterHorizontally
         )
        {
            Text("Minha Conta")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MinhaContaPreview(){
    MinhaConta()
}