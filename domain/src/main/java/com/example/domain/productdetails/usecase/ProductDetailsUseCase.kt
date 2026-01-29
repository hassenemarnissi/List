package com.example.domain.productdetails.usecase

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.result.Result

interface ProductDetailsUseCase {
    suspend operator fun invoke(id: Int): Result<ProductDetailEntity>
}