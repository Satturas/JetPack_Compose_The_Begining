package com.example.jetpackcomposethebegining

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    val contact1 = Contact(
        familyName = "Лукашин",
        name = "Евгений Андреевич",
        phone = R.string.phone.toString(),
        email = R.string.email.toString(),
        address = R.string.address.toString()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ContactDetails(contact1) }
    }

    @Composable
    private fun ContactDetails(contact: Contact) {

    }

    @Composable
    fun ContactColumn(contact: Contact) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                RoundInitials("${contact.name.first()}${contact.familyName.first()}")
                Text("Имя: ${contact.name}")
                Text("Отчество: ${contact.surname.orEmpty()}")
                Text("Фамилия: ${contact.familyName}")
                Text("Мобильный телефон: ${contact.phone}")
                Text("Адрес: ${contact.address}")
            }
            if (contact.isFavorite) Image(
                modifier = Modifier.padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = null
            )
        }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactColumnPreview() {
        ContactColumn(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                isFavorite = true
            )
        )
    }

    @Composable
    fun RoundInitials(initials: String) {
        Box(
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                )
                Text(fontWeight = FontWeight(1000),
                text = initials)
            }
        }
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
            painter = painterResource(id = R.drawable.circle),
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

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun RoundInitialsPreview() {
        RoundInitials("АБ")
    }

    @Composable
    fun ContactColumn5(contact: Contact) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
                    .weight(0.25F),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    style = MaterialTheme.typography.h6,
                    text = "${contact.name} ${contact.surname.orEmpty()}"
                )
                Text(
                    style = MaterialTheme.typography.h5,
                    text = contact.familyName
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(0.75F),
            ) {
                Text("Мобильный телефон: ${contact.phone}")
                Text("Адрес: ${contact.address}")
            }
        }
    }



    @Composable
    fun ContactColumn2(contact: Contact) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: ${contact.name}")
            Text("Отчество: ${contact.surname.orEmpty()}")
            Text("Фамилия: ${contact.familyName}")
            Text("Мобильный телефон: ${contact.phone}")
            Text("Адрес: ${contact.address}")
        }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactColumnPreview2() {
        ContactColumn2(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
            )
        )
    }

    @Composable
    fun Contacts(items: List<Contact>) {
        Column { items.forEach { ContactColumn2(it) } }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ListPreview() {
        Contacts(
            listOf(
                Contact(
                    name = "Евгений",
                    surname = "Андреевич",
                    familyName = "Лукашин",
                    phone = "+7 495 495 95 95",
                    address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
                ),
                Contact(
                    name = "Василий",
                    surname = "Егорович",
                    familyName = "Кузякин",
                    phone = " --- ",
                    address = "Ивановская область, дер. Крутово, д. 4"
                ),
                Contact(
                    name = "Людмила",
                    surname = "Прокофьевна",
                    familyName = "Калугина",
                    phone = "+7 495 788 78 78",
                    address = "Москва, Большая Никитская, д. 43, кв. 290"
                )
            )
        )
    }

    @Composable
    fun ContactColumn3(contact: Contact) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            Column(
                modifier = Modifier.weight(1F),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text("Имя: ${contact.name}")
                Text("Отчество: ${contact.surname.orEmpty()}")
                Text("Фамилия: ${contact.familyName}")
                Text("Мобильный телефон: ${contact.phone}")
                Text("Адрес: ${contact.address}")
            }
            if (contact.isFavorite) Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = android.R.drawable.star_big_on),
                contentDescription = null
            )
        }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactColumnPreview3() {
        ContactColumn2(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
            )
        )
    }
}