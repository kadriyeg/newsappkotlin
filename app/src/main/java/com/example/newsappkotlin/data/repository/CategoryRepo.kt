package com.example.newsappkotlin.data.repository

import retrofit2.Callback
import androidx.lifecycle.MutableLiveData
import com.example.newsappkotlin.common.Retrofit
import com.example.newsappkotlin.data.model.Category
import retrofit2.Call
import retrofit2.Response

class CategoryRepo {

    fun list(category:String):MutableLiveData<Category>{

        val result = MutableLiveData<Category>()

        Retrofit.category().getCategory(category).enqueue(object:Callback<Category>{

            override fun onResponse(call: Call<Category>, response: Response<Category>) {

                if(response.isSuccessful){

                    result.value=response.body()
                }
            }

            override fun onFailure(call: Call<Category>, t: Throwable) {}

        })

        return result
    }
}