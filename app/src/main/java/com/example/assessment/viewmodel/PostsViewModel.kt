package com.example.assessment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment.models.Post
import com.example.assessment.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    val postsRepository = PostsRepository()
    var postsLiveData = MutableLiveData<List<Post>>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchPosts(){
        viewModelScope.launch{
val response = postsRepository.getPost()
            if (response.isSuccessful){
                val postsList = response.body()?: emptyList()

                postsLiveData.postValue((postsList))
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}