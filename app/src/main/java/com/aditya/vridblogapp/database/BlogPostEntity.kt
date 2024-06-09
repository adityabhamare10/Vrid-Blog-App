package com.aditya.vridblogapp.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "blog_posts")
data class BlogPostEntity(
    @PrimaryKey val id: Int,
    val titleRendered: String,
    val contentRendered: String
)
