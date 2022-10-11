package com.example.newsappkotlin.data.remote

import com.example.newsappkotlin.data.model.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryAPI {

    @GET("news")
    fun getCategory(
        @Query("category")name:String
    ): Call<Category>
}