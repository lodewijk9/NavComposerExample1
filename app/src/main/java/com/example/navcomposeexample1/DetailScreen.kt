package com.example.navcomposeexample1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(name:String, navigateBack:()->Unit) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Detail Screen $name", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = {  }) {
            Text(
                text = "Go to Settings"
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { navigateBack() }) {
            Text(
                text = "Log Out"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}