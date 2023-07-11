package com.example.anitab_api_products

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anitab_api_products.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume(){
        super.onResume()
        fetchProduct()
    }
    fun fetchProduct(){
        val apiClient=ApiClient.buildClient(ApiInterface::class.java)
        val request=apiClient.getProducts()
        request.enqueue(object : Callback<ProductResponse>{
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    var productData = response.body()?.products?: emptyList<Product>()
//                    binding.rvProducts.layoutManager = LinearLayoutManager(this@MainActivity)
                     binding.rvProducts.layoutManager = GridLayoutManager(this@MainActivity,2)
                    binding.rvProducts.adapter = ProductAdapter(productData)



                    Toast.makeText(
                        baseContext,
                        "fetched ${productData?.size} products", Toast.LENGTH_SHORT).show()

                }else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }
        })
    }
}








