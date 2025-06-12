package com.example.navcomposeexample1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.navcomposeexample1.core.navigation.NavigationWrapper
import com.example.navcomposeexample1.ui.theme.NavComposeExample1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavComposeExample1Theme {
                NavigationWrapper()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavComposeExample1Theme {

    }
}