package com.example.data.productlist.mapper

import com.example.data.productdetails.model.ProductModel
import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.SaleType
import javax.inject.Inject

class ProductMapperImpl @Inject constructor() : ProductMapper {
    override fun map(model: ProductModel): ProductEntity =
        ProductEntity(
            id = model.id,
            thumbnail = model.thumbnail ,
            title = model.title,
            brand = model.brand.takeIf { it?.isNotBlank() == true },
            rating = model.rating,
            reviewsCount = model.reviews.size,
            price = model.price,
            finalPrice = model.price * (1 - model.discountPercentage / 100),
            discountPercentage = model.discountPercentage,
            availability = if (model.stock > 0)
                Availability.IN_STOCK else Availability.OUT_OF_STOCK,
            saleType = if (model.minimumOrderQuantity > 1)
                SaleType.WHOLESALE
            else
                SaleType.RETAIL(model.minimumOrderQuantity)
        )

    override fun mapList(models: List<ProductModel>): List<ProductEntity> =
        models.map(transform = ::map)

}