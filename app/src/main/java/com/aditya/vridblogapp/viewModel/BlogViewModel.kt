package com.aditya.vridblogapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aditya.vridblogapp.model.BlogPost
import com.aditya.vridblogapp.repository.BlogRepository
import kotlinx.coroutines.launch


class BlogViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = BlogRepository()

    private val _blogPosts = MutableLiveData<List<BlogPost>>()
    val blogPosts: LiveData<List<BlogPost>> = _blogPosts

    fun fetchBlogPosts() {
        viewModelScope.launch {
            val posts = repository.getBlogPosts()
            _blogPosts.postValue(posts)
        }
    }
}
