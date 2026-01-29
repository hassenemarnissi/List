package com.example.data.productlist.datasource

import com.example.data.common.safecall.safeApiCall
import com.example.data.productlist.api.ProductListApi
import com.example.data.productlist.model.ProductsResponseModel
import javax.inject.Inject
import com.example.domain.result.Result

class ProductListRemoteDataSourceImpl @Inject constructor(private val api: ProductListApi): ProductListRemoteDataSource{
    override suspend fun getProducts(
        limit: Int,
        skip: Int
    ): Result<ProductsResponseModel> =
        safeApiCall(
            caller = "getProducts",
            className = this::class.java.simpleName
        ) {
            api.getProducts(limit, skip)
        }

}