package com.example.assessment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.assessment.models.PostEntity
import com.example.assessment.repository.PostRepository

class PostViewModel(private val repository: PostRepository) : ViewModel() {
    val posts: LiveData<List<PostEntity>> = repository.allPosts

    init {
        viewModelScope.launch {
            repository.refreshPosts()
        }
    }
}