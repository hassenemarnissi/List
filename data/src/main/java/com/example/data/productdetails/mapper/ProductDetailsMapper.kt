package com.example.data.productdetails.mapper

import com.example.data.productdetails.model.ProductModel
import com.example.domain.productdetails.entity.ProductDetailEntity

interface ProductDetailsMapper {
    fun map(model: ProductModel): ProductDetailEntity
}