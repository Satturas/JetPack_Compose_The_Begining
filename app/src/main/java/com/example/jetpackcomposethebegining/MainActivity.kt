package com.example.jetpackcomposethebegining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
    fun ImagePreview() {
        Image(
            modifier = Modifier
                .size(240.dp, 120.dp)
                .background(Color.Black),
            painter = painterResource(id = R.drawable.image),
            contentScale = ContentScale.None,
            alignment = Alignment.TopEnd,
            contentDescription = stringResource(id = R.string.standard_icon)
        )
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ButtonPreview() {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { Log.d("ButtonPreview", "Кнопка нажата") },
            content = { Text("Нажми меня", color = Color.Black) },
            enabled = true,
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.elevation(defaultElevation = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        )
    }

    @Composable
    fun RoundInitials(initials: String) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = null,
                )
                Text(initials)
            }
        }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun RoundInitialsPreview() {
        RoundInitials("АБ")
    }
}