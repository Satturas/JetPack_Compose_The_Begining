package com.example.jetpackcomposethebegining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { HelloWorld() }
    }

    @Composable
    private fun HelloWorld() {
        Text("Hello World!")
    }

    @Composable
    private fun Hello(name: String?) {
        name?.let { Text("Hello, $name!") } ?: Text("Имя не задано")
    }

    @Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
    @Composable
    fun HelloPreview() {
        Hello("Android")
    }

    @Preview(device = "spec:width=411dp,height=891dp", showSystemUi = true)
    @Composable
    fun HelloNullPreview() {
        Hello(null)
    }
}