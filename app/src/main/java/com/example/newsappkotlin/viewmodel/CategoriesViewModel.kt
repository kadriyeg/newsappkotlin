package com.example.newsappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappkotlin.data.model.Category
import com.example.newsappkotlin.data.repository.CategoryRepo

class CategoriesViewModel : ViewModel() {

    private var categoryRepo = CategoryRepo()
    val errorMessage = MutableLiveData<Boolean>()
    val categories = MutableLiveData<List<Category>>()
    val categoryUploading = MutableLiveData<Boolean>()

    /*fun refreshData(){
        val test = Category("TEST 1", "TEST DATA", true)
        val categoryListVM = arrayListOf<Category>()
        categories.value=categoryListVM
        errorMessage.value=false
        categoryUploading.value=false
    }*/

    fun list(category:String):MutableLiveData<Category>{

        return categoryRepo.list(category)
    }

}