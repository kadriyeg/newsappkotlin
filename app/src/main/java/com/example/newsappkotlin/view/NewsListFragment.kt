package com.example.newsappkotlin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.newsappkotlin.R
import com.example.newsappkotlin.databinding.FragmentNewsListBinding
import com.example.newsappkotlin.viewmodel.CategoriesViewModel
import com.example.newsappkotlin.viewmodel.NewsListViewModel

class NewsListFragment : Fragment() {

    private lateinit var viewModel: CategoriesViewModel
    private var categoryId=0
    private lateinit var dataBinding: FragmentNewsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_news_list, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            categoryId = NewsListFragmentArgs.fromBundle(it).categoryId
        }
        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)

    }
}
