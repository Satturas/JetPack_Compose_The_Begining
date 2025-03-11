package com.example.jetpackcomposethebegining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun TextPreview1() {
        Text(
            modifier = Modifier
                .width(120.dp)
                .height(60.dp),
            text = stringResource(R.string.jetpack_text),
        )
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun TextPreview2() {
        Text(
            text = stringResource(R.string.jetpack_text),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun TextPreview3() {
        Text(
            modifier = Modifier
                .size(width = 120.dp, height = 60.dp)
                .background(Color.LightGray),
            text = stringResource(R.string.jetpack_text),
        )
    }
}