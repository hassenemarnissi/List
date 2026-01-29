package com.example.data.productlist.datasource

import com.example.data.productlist.model.ProductsResponseModel
import com.example.domain.result.Result

interface ProductListRemoteDataSource {
    suspend fun getProducts(
        limit: Int,
        skip: Int,
    ): Result<ProductsResponseModel>
}