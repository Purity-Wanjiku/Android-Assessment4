package com.example.assessment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var postViewModel: PostViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postAdapter = PostAdapter(emptyList()) // Initialize with empty list
        recyclerView.adapter = postAdapter

        val postDao = AppDatabase.getDatabase(this).postDao()
        val repository = PostRepository(postDao)
        postViewModel = ViewModelProvider(this, PostViewModelFactory(repository)).get(PostViewModel::class.java)

        postViewModel.posts.observe(this, { posts ->
            postAdapter.updateData(posts)
        })

        GlobalScope.launch(Dispatchers.IO) {
            postViewModel.refreshPosts()
        }
    }
}
