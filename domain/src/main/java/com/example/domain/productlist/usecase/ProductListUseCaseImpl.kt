package com.example.domain.productlist.usecase

import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.listing.Listing
import com.example.domain.productlist.repository.ProductListRepository
import com.example.domain.result.Result
import javax.inject.Inject

class ProductListUseCaseImpl @Inject constructor(
    private val repository: ProductListRepository
) : ProductListUseCase {

    override suspend operator fun invoke(): Result<Listing<ProductEntity>> =
        repository.getProducts()
}