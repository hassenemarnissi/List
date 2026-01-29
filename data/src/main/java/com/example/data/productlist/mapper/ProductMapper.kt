package com.example.data.productlist.mapper

import com.example.data.productdetails.model.ProductModel
import com.example.domain.productlist.entity.ProductEntity

interface ProductMapper {
    fun map(model: ProductModel): ProductEntity
    fun mapList(models: List<ProductModel>): List<ProductEntity>

}