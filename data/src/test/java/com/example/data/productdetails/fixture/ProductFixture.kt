package com.example.data.productdetails.fixture


import com.example.data.productdetails.model.DimensionsModel
import com.example.data.productdetails.model.MetaModel
import com.example.data.productdetails.model.ProductModel
import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.SaleType.WHOLESALE

object ProductFixture {

    fun productModel(): ProductModel =
        ProductModel(
            id = 1,
            title = "title",
            description = "description",
            category = "category",
            price = 99.99,
            discountPercentage = 10.0,
            rating = 4.3,
            stock = 10,
            tags = listOf("tag1", "tag2"),
            brand = "Brand",
            sku = "SKU-123",
            weight = 500,
            dimensions = productDimensions(),
            warrantyInformation = "2 years",
            shippingInformation = "Ships in 48h",
            availabilityStatus = "In Stock",
            reviews = emptyList(),
            returnPolicy = "30 days",
            minimumOrderQuantity = 1,
            meta = productMeta(),
            images = emptyList(),
            thumbnail = "https://thumbnail"
        )

    private fun productDimensions() =
        DimensionsModel(10.0, 10.0, 10.0)

    private fun productMeta() =
        MetaModel(
            createdAt = "",
            updatedAt = "",
            barcode = "",
            qrCode = ""
        )

    fun productEntity(): ProductEntity = ProductEntity(
        id = 1,
        thumbnail = "https://thumbnail",
        title = "title",
        brand = "Brand",
        reviewsCount = 2,
        rating = 4.3,
        price = 99.99,
        finalPrice = 99.99,
        discountPercentage = 1.0,
        availability = Availability.IN_STOCK,
        saleType = WHOLESALE
    )
    fun productDetailsEntity(): ProductDetailEntity = ProductDetailEntity(
        id = 1,
        thumbnail = "https://thumbnail",
        title = "title",
        brand = "Brand",
        reviewsCount = 2,
        rating = 4.3,
        price = 99.99,
        finalPrice = 99.99,
        discountPercentage = 1.0,
        availability = Availability.IN_STOCK,
        saleType = WHOLESALE,
        tags = listOf("tag1", "tag2"),
        stock = 1,
        warrantyInfo = "",
        returnPolicy = "",
        shippingInfo = "",
        images = listOf(),
        description = "description",
        category = "category",
    )
}
