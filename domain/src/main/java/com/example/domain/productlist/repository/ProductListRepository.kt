package com.example.domain.productlist.repository

import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.listing.Listing
import com.example.domain.result.Result

interface ProductListRepository {
    suspend fun getProducts(): Result<Listing<ProductEntity>>
}