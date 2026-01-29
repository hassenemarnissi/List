package com.example.data.productdetails.datasource

import com.example.data.common.safecall.safeApiCall
import com.example.data.productdetails.api.ProductDetailsApi
import com.example.data.productdetails.model.ProductModel
import com.example.domain.result.Result
import javax.inject.Inject

class ProductDetailsRemoteDataSourceImpl @Inject constructor(private val productDetailsApi: ProductDetailsApi):ProductDetailsRemoteDataSource {
    override suspend fun getProductById(id: Int): Result<ProductModel> =
        safeApiCall(
            caller = "getProductById",
            className = this::class.java.simpleName
        ) {
            productDetailsApi.getProductById(id)
        }
}