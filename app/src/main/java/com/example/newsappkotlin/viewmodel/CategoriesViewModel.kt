package com.example.newsappkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsappkotlin.model.Category

class CategoriesViewModel : ViewModel() {
    val errorMessage = MutableLiveData<Boolean>()
    val categories = MutableLiveData<List<Category>>()
    val categoryUploading = MutableLiveData<Boolean>()

    fun refreshData(){
        val test = Category("TEST 1", "TEST DATA", true)
        val categoryListVM = arrayListOf<Category>()
        categories.value=categoryListVM
        errorMessage.value=false
        categoryUploading.value=false
    }

}