package com.example.assessment.api

import com.example.assessment.models.Post
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
     fun getPosts(): Call<List<Post>>
}