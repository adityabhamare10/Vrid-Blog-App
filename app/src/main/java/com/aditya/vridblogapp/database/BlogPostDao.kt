package com.aditya.vridblogapp.database
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlogPostDao {
    @Query("SELECT * FROM blog_posts")
    suspend fun getBlogPosts(): List<BlogPostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBlogPosts(blogPosts: List<BlogPostEntity>)
}
