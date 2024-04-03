package com.example.stayenka.model

import java.io.Serializable

data class category_model(


    val image:Int,
    val name:String,
    val locate:String,
    val price:String,
    val list: space_model


):Serializable