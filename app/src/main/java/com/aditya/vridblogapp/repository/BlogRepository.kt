package com.aditya.vridblogapp.repository

import Api
import RetrofitInstance
import com.aditya.vridblogapp.model.BlogPost
import com.aditya.vridblogapp.model.Title
import com.aditya.vridblogapp.model.Content
import com.aditya.vridblogapp.database.BlogPostDao
import com.aditya.vridblogapp.database.BlogPostEntity

class BlogRepository(private val blogPostDao: BlogPostDao, private val apiService: Api) {

    suspend fun getBlogPosts(): List<BlogPost> {
        return try {
            val response = apiService.getBlogPosts()
            val blogPosts = response.map {
                BlogPostEntity(
                    id = it.id,
                    titleRendered = it.title.rendered,
                    contentRendered = it.content.rendered
                )
            }
            blogPostDao.insertBlogPosts(blogPosts)
            response // Returning the API response
        } catch (e: Exception) {
            blogPostDao.getBlogPosts().map {
                BlogPost(
                    id = it.id,
                    title = Title(it.titleRendered),
                    content = Content(it.contentRendered)
                )
            }
        }
    }
}
