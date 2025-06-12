package com.example.navcomposeexample1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(messageToDetail:(String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Home Screen", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = text,
            onValueChange = {text = it}
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { messageToDetail(text) }) {
            Text(
                text = "Go to detail"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}