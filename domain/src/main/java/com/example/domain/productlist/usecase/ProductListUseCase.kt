package com.example.domain.productlist.usecase

import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.listing.Listing
import com.example.domain.result.Result

interface ProductListUseCase {
    suspend operator fun invoke(): Result<Listing<ProductEntity>>
}