package com.example.navcomposeexample1

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

@Composable
fun LoginScreen(NavigateToHome: () -> Unit) {
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = "Login Screen", fontSize = 25.sp)
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { NavigateToHome() }) {
            Text(
                text = "Go to home"
            )
        }
        // using a deeplink from inside the application
        Button(onClick = {
            val uri = "https://lodewijk.dev/home"
            val intent = Intent(Intent.ACTION_VIEW, uri.toUri())
            context.startActivity(intent)
        }) {
            Text(
                text = "deep link go to Home"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}