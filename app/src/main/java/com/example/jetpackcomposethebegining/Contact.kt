package com.example.jetpackcomposethebegining

data class Contact(
    val name: String, //Имя
    val surname: String? = null, //Отчество
    val familyName: String, //Фамилия
    val isFavorite: Boolean = false,//Признак избранного контакта
    val phone: String, //Телефон
    val address: String //Адрес
)
