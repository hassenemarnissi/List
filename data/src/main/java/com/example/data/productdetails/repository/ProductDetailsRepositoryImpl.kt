package com.example.data.productdetails.repository

import com.example.data.productdetails.datasource.ProductDetailsRemoteDataSource
import com.example.data.productdetails.mapper.ProductDetailsMapper
import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productdetails.repository.ProductDetailsRepository
import com.example.domain.result.Failure
import com.example.domain.result.Result
import com.example.domain.result.Success
import javax.inject.Inject

class ProductDetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductDetailsRemoteDataSource,
    private val productDetailsMapper: ProductDetailsMapper
) : ProductDetailsRepository {
    override suspend fun getProductById(id: Int): Result<ProductDetailEntity> =
       when (val result = remoteDataSource.getProductById(id)) {
            is Success -> Success(productDetailsMapper.map(result.value))
            is Failure -> result
        }
}