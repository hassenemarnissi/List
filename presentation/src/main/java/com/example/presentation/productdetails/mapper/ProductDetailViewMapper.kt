package com.example.presentation.productdetails.mapper

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.presentation.productdetails.viewelement.ProductDetailViewElement

interface ProductDetailViewMapper {
    fun map(entity: ProductDetailEntity): ProductDetailViewElement
}
