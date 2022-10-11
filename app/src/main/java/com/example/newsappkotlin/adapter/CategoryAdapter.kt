package com.example.newsappkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappkotlin.databinding.CategoriesRecycleRowBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(var view: CategoriesRecycleRowBinding) : RecyclerView.ViewHolder(view.root)
    //private var categoriesList = emptyList<Category>()
    var categoriesList = ArrayList<String>()
    fun initList() {
        categoriesList.add("all")
        categoriesList.add("national //Indian News only")
        categoriesList.add("business")
        categoriesList.add("sports")
        categoriesList.add("world")
        categoriesList.add("politics")
        categoriesList.add("technology")
        categoriesList.add("startup")
        categoriesList.add("entertainment")
        categoriesList.add("miscellaneous")
        categoriesList.add("hatke")
        categoriesList.add("science")
        categoriesList.add("automobile")


        class CategoryViewHolder(val binding: CategoriesRecycleRowBinding) :
            RecyclerView.ViewHolder(binding.root)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return  CategoryViewHolder(
            CategoriesRecycleRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val categoryData = categoriesList[position]
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }
}

   /* class CategoryAdapter (val categoryList : ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(var view: CategoriesRecycleRowBinding) : RecyclerView.ViewHolder(view.root)

    {
        //val textView : TextView = itemView.findViewById(R.id.kateori_rwText)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
       // val view = inflater.inflate(R.layout.categories_recycle_row,parent,false)
        val view = DataBindingUtil.inflate<CategoriesRecycleRowBinding>(LayoutInflater.from(parent.context),R.layout.categories_recycle_row, parent,false)
        //val view = DataBindingUtil.inflate<CategoriesRecycleRowBinding>(inflater,R.layout.categories_recycle_row,parent,false)
        return CategoryViewHolder(view)
    }



    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.view.categoryData = categoryList[position]

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun updateCategories(newCategoryList : List<Category>){
        categoryList.clear()
        categoryList.addAll(newCategoryList)
        notifyDataSetChanged()
    }*/
