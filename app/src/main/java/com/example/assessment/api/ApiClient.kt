package com.example.assessment.api

import com.example.assessment.models.PostEntity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val apiService = retrofit.create(ApiService::class.java)

//    fetch data n insert to database
    suspend fun refreshPosts() {
        val posts = apiService.getPosts()
        val postEntities = posts.map { PostEntity(it.id, it.title, it.body) }
        postDao.insertPosts(postEntities)
    }
}