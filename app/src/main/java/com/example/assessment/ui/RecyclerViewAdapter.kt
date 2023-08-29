package com.example.assessment.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.assessment.R
import com.example.assessment.databinding.ActivityMainBinding
import com.example.assessment.models.Post

class PostAdapter (var postsList: List<Post>): RecyclerView.Adapter<PostAdapter.PostsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
      val  binding =
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
  val post = postsList[position]
        holder.
    }


    class PostsViewHolder(var binding: PostsList):

}