package com.aditya.vridblogapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
//import com.aditya.vridblogapp.viewModel.BlogViewModel
import com.aditya.vridblogapp.viewmodel.BlogViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var viewModel: BlogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialization logic if needed
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlogViewModel::class.java)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.blogPosts.observe(viewLifecycleOwner, { blogPosts ->
            recyclerView.adapter = BlogAdapter(blogPosts) { blogPost ->
//                val action = ListFragmentDirections.actionListFragmentToDetailFragment(blogPost.content.rendered)
//                findNavController().navigate(action)
                val bundle = Bundle().apply {
                    putString("content", blogPost.content.rendered)
                }
                Navigation.findNavController(view)
                    .navigate(R.id.action_listFragment_to_detailFragment, bundle)
            }
        })

        viewModel.fetchBlogPosts()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
