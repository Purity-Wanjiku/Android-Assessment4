package com.example.assessment.repository

import com.example.assessment.api.ApiClient
import com.example.assessment.api.ApiInterface
import com.example.assessment.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class PostsRepository {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun getPost(): Call<List<Post>> {
        return withContext(Dispatchers.IO){
            apiClient.getPosts()
        }
    }
}