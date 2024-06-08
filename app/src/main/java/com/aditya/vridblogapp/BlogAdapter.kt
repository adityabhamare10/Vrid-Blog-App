package com.aditya.vridblogapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aditya.vridblogapp.model.BlogPost

class BlogAdapter(private val blogPosts: List<BlogPost>, private val onItemClick: (BlogPost) -> Unit) :
    RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {

    inner class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.blog_title)

        fun bind(blogPost: BlogPost) {
            titleTextView.text = blogPost.title.rendered
            itemView.setOnClickListener { onItemClick(blogPost) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(view)
    }

    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        holder.bind(blogPosts[position])
    }

    override fun getItemCount(): Int = blogPosts.size
}
