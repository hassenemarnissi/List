package com.example.presentation.productdetails

import com.example.domain.productdetails.entity.ProductDetailEntity

object  ProductDetailsFixture {
    fun productDetailEntity(): ProductDetailEntity = ProductDetailEntity(
    id = 1,
    title = "title",
    description = "description",
    category = "category",
    brand = "brand",
    price = 1200.0,
    finalPrice = 999.99,
    discountPercentage = 20.0,
    rating = 4.7,
    reviewsCount = 120,
    availability = productAvailability(),
    saleType = productSaleType(),
    stock = 10,
    tags = listOf("tag"),
    images = emptyList(),
    thumbnail = "https://thumbnail",
    shippingInfo = "in 48h",
    warrantyInfo = "1 an",
    returnPolicy = "30 jours"
    )
    private fun productAvailability() =
        com.example.domain.productlist.entity.Availability.IN_STOCK

    private fun productSaleType() =
        com.example.domain.productlist.entity.SaleType.WHOLESALE
}