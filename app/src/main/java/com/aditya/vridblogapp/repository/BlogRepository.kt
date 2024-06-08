package com.aditya.vridblogapp.repository

import com.aditya.vridblogapp.model.BlogPost

class BlogRepository {

    suspend fun getBlogPosts(): List<BlogPost> {
        return RetrofitInstance.api.getBlogPosts()
    }

}