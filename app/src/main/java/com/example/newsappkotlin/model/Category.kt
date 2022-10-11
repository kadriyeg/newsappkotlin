package com.example.newsappkotlin.model

import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("category")
    val category:String?,
    @SerializedName("data")
    val data: String?,
    @SerializedName("success")
    val success:Boolean?) {
}