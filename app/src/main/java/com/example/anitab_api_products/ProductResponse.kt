package com.example.anitab_api_products

data class ProductResponse(
    var products: List<Product>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
