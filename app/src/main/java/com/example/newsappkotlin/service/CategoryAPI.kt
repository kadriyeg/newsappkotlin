package com.example.newsappkotlin.service

import com.example.newsappkotlin.model.Category
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryAPI {
    //https://inshorts.deta.dev/news?category=all
    @GET("news")
    fun getCategory(
        @Query("category")categoryname:String
    ):Single <List<Category>>
}