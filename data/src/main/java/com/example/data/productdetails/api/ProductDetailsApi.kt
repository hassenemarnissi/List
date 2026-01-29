package com.example.data.productdetails.api

import com.example.data.productdetails.model.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailsApi {
    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductModel
}