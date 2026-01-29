package com.example.domain.productdetails.entity

import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.SaleType

data class ProductDetailEntity(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val brand: String?,
    val price: Double,
    val finalPrice: Double,
    val discountPercentage: Double?,
    val rating: Double,
    val reviewsCount: Int,
    val availability: Availability,
    val saleType: SaleType,
    val stock: Int,
    val tags: List<String>,
    val images: List<String>,
    val thumbnail: String,
    val shippingInfo: String?,
    val warrantyInfo: String?,
    val returnPolicy: String?
)