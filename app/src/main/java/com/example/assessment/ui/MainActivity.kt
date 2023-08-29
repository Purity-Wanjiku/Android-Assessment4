package com.example.assessment.ui

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.assessment.api.ApiClient
import com.example.assessment.api.ApiInterface
import com.example.assessment.databinding.ActivityMainBinding
import com.example.assessment.models.Post
import com.example.assessment.viewmodel.PostsViewModel
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityMainBinding
val postsViewModel:PostsViewModel by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPosts()
    }


    fun getPosts(){
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = retrofit.getPosts()

        request.enqueue(object: Callback<List<Post>>{
            override fun onResponse(call : Call<List<Post>>, response: Response<List<Post>>){
                if (response.isSuccessful){
                    val posts = response.body()
                    Toast.makeText(this, "${posts!!.size} posts", Toast.LENGTH_LONG).show()
                }
                else {
                    Log.e("API", "Response unsuccessful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable){

            }
        })
    }
}
