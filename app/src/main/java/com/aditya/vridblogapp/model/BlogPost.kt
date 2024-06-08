package com.aditya.vridblogapp.model

data class Title(
    val rendered: String
)

data class Content(
    val rendered: String
)

data class BlogPost(
    val id: Int,
    val title: Title,
    val content: Content
)
