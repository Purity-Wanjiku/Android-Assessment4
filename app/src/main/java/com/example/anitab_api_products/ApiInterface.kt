package com.example.anitab_api_products

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body

interface ApiInterface {
    @GET ("/product")
    fun getProducts (): Call <ProductResponse>

    @GET ("product/{id}")
    fun getProductById(@Path("id")productId:Int):Call <Product>

    @POST("/product")
    fun  postProduct(@Body product:Product):Call<Product>
}