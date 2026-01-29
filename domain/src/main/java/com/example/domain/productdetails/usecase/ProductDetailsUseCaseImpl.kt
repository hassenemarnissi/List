package com.example.domain.productdetails.usecase

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productdetails.repository.ProductDetailsRepository
import com.example.domain.result.Result
import javax.inject.Inject

class ProductDetailsUseCaseImpl @Inject constructor(val repository: ProductDetailsRepository):ProductDetailsUseCase {
    override suspend fun invoke(id: Int): Result<ProductDetailEntity> =
        repository.getProductById(id)
}