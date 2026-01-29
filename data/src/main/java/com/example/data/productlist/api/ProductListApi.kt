package com.example.data.productlist.api

import com.example.data.productlist.model.ProductsResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductListApi {
    @GET("/products")
    suspend fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int,
    ):ProductsResponseModel
}