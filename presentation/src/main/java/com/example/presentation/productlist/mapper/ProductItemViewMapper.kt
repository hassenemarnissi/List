package com.example.presentation.productlist.mapper

import com.example.domain.productlist.entity.ProductEntity
import com.example.presentation.productlist.viewelement.ProductItemViewElement

interface ProductItemViewMapper {
    fun map(entity: ProductEntity): ProductItemViewElement
}