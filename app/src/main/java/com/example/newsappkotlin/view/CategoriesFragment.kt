package com.example.newsappkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappkotlin.R
import com.example.newsappkotlin.adapter.CategoryAdapter
import com.example.newsappkotlin.databinding.FragmentCategoriesBinding
import com.example.newsappkotlin.viewmodel.CategoriesViewModel

class CategoriesFragment : Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    private lateinit var viewModel: CategoriesViewModel
    private val categoryRecyclerAdapter : CategoryAdapter by lazy { CategoryAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        val view=binding.root
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        viewModel.refreshData()
      //  val recyclerView : RecyclerView = view.findViewById(R.id.categoryRecycler)
    binding.categoryRecycler.layoutManager=LinearLayoutManager(context)
        binding.categoryRecycler.adapter = categoryRecyclerAdapter
        observeLiveData()
    }
    fun observeLiveData(){
        viewModel.categories.observe(viewLifecycleOwner, Observer { categories ->
            categories?.let {

                binding.categoryRecycler.visibility=View.VISIBLE
                //categoryRecyclerAdapter.updateCategories(categories)
            }
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error->
            error?.let {
                if(it){
                    binding.categoryErrorMessage.visibility= View.VISIBLE
                    binding.categoryRecycler.visibility=View.GONE
                } else {
                    binding.categoryErrorMessage.visibility = View.GONE
                }
            }
        })

        viewModel.categoryUploading.observe(viewLifecycleOwner, Observer { uploading ->
            uploading?.let {
                if(it){
                    binding.progressBar.visibility=View.VISIBLE
                    binding.categoryErrorMessage.visibility = View.GONE
                    binding.categoryRecycler.visibility=View.GONE
                } else {
                    binding.categoryRecycler.visibility=View.GONE
                }
            }
        })
        }
    }




