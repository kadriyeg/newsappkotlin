package com.example.newsappkotlin.service

import com.example.newsappkotlin.model.Category
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CategoryAPIService {
    //https://inshorts.deta.dev/news?category=all

    private  val BASE_URL = "https://inshorts.deta.dev/"
    private val IMAGE_BASE_URL = "https://static.inshorts.com/inshorts/images/v1/variants/jpg"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CategoryAPI::class.java)
    private val imageApi = Retrofit.Builder()
        .baseUrl(IMAGE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CategoryAPI::class.java)

    fun getData() : Single<List<Category>> {
        return api.getCategory("all")
    }


}
