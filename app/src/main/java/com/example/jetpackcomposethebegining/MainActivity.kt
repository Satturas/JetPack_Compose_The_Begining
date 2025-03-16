package com.example.jetpackcomposethebegining

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    private val contact1 = Contact(
        name = "Евгений",
        surname = "Андреевич",
        familyName = "Лукашин",
        phone = "+7 495 495 95 95",
        address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12",
        isFavorite = true,
        email = "blabla@gmail.com"
    )

    private val contact2 = Contact(
        name = "Василий",
        familyName = "Пупкин",
        phone = "+7 999 777 77 77",
        address = "Бейкер стрит 221Б",
        isFavorite = false,
        imageRes = R.drawable.avatar
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ContactDetails(contact2) }
    }

    @Composable
    private fun ContactDetails(contact: Contact) {
        ContactColumn(contact)
    }

    @Composable
    fun ContactColumn(contact: Contact) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (contact.imageRes == null) {
                RoundInitials("${contact.name.first()}${contact.familyName.first()}")
            } else {
                Avatar()
            }

            Text(
                "${contact.name} ${contact.surname.orEmpty()}",
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight(500)
            )
            Row(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 44.dp)
            ) {
                Text(
                    text = contact.familyName,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight(500),
                )
                if (contact.isFavorite) Image(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = null
                )
            }
            InfoRow(title = stringResource(R.string.phone), info = contact.phone)
            InfoRow(title = stringResource(R.string.address), info = contact.address)
            if (!contact.email.isNullOrEmpty()) {
                InfoRow(title = stringResource(R.string.email), info = contact.email)
            }
        }
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactColumnPreview1() {
        ContactColumn(contact1)
    }

    @Preview(name = "portrait", showSystemUi = true)
    @Composable
    fun ContactColumnPreview2() {
        ContactColumn(contact2)
    }

    @Composable
    fun RoundInitials(initials: String) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = null,
                )
                Text(
                    fontWeight = FontWeight(1000),
                    text = initials
                )
            }
        }
    }

    @Composable
    fun InfoRow(title: String, info: String) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(0.5F)
                    .align(Alignment.CenterVertically),
                text = "$title:",
                style = MaterialTheme.typography.body1,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight(400),
                textAlign = TextAlign.End
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
                    .weight(0.5F),
                text = info,
                style = MaterialTheme.typography.body2,
                maxLines = 3
            )
        }
    }

    @Composable
    fun Avatar() {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(120.dp)
                    .height(height = 80.dp),
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
            )
        }
    }
}

