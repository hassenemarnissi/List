package com.example.domain.productdetails.repository

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.result.Result

interface ProductDetailsRepository {
    suspend fun getProductById(id:Int):Result<ProductDetailEntity>
}