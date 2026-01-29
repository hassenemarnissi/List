package com.example.domain.productlist.entity

data class ProductEntity (
    val id: Int,
    val thumbnail: String,
    val title: String,
    val brand: String?,
    val rating: Double,
    val reviewsCount:Int ,
    val price: Double ,
    val finalPrice: Double,
    val discountPercentage: Double,
    val availability: Availability,
    val saleType: SaleType
)
