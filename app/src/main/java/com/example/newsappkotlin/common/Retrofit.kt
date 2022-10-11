package com.example.newsappkotlin.common

import com.example.newsappkotlin.data.remote.CategoryAPI
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    fun category(): CategoryAPI {

        val category: CategoryAPI by lazy { retrofit(Constants.BASE_URL).create(CategoryAPI::class.java) }

        return category
    }


    private fun retrofit(url:String):Retrofit{

        val gson=GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}