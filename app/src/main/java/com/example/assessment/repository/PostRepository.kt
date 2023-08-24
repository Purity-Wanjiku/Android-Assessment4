package com.example.assessment.repository

import androidx.lifecycle.LiveData
import com.example.assessment.api.ApiClient.apiService
import com.example.assessment.database.ApiService
import com.example.assessment.database.PostDao
import com.example.assessment.models.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




    class PostRepository(private val postDao: PostDao) {

        val allPosts: LiveData<List<PostEntity>> = postDao.getAllPosts()

        suspend fun refreshPosts() {
            try {
                val response = apiService.getPosts()
                val postEntities = posts.map { PostEntity(it.id, it.title, it.body) }
                postDao.insertPosts(postEntities)


                // Fetch posts from the API
//                val response = apiService.getPosts()

                if (response.isSuccessful) {
                    val posts = response.body() ?: emptyList()

                    // Convert API response to Entity and insert into the database
                    val postEntities = posts.map { post ->
                        PostEntity(id = post.id, title = post.title, body = post.body)
                    }
                    postDao.insertAll(postEntities)
                } else {
                    // Handle unsuccessful API response
                    // You can log an error or take appropriate action
                }
            } catch (e: Exception) {
                // Handle exceptions
                // You can log an error or take appropriate action
            }
        }
    }


