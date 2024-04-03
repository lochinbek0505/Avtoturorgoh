package com.example.stayenka.model

import java.io.Serializable

data class Item(
    val id: Int = 0,
    val name: String,
    val location: String,
    val price: String,
    val fromDate: String,
    val endDate: String,
    val limit: String,
    val number: String,
    val qrText: String
):Serializable
