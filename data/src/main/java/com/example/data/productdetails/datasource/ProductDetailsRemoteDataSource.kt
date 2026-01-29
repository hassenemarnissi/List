package com.example.data.productdetails.datasource

import com.example.data.productdetails.model.ProductModel
import com.example.domain.result.Result


interface ProductDetailsRemoteDataSource {
    suspend fun getProductById(id: Int): Result<ProductModel>
}