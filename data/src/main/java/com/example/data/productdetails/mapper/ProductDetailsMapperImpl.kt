package com.example.data.productdetails.mapper

import com.example.data.productdetails.model.ProductModel
import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.SaleType
import javax.inject.Inject

class ProductDetailsMapperImpl @Inject constructor(): ProductDetailsMapper {
    override fun map(model: ProductModel): ProductDetailEntity =
        ProductDetailEntity(
            id = model.id,
            title = model.title,
            description = model.description,
            category = model.category,
            brand = model.brand.takeIf { it?.isNotBlank() == true },
            price = model.price,
            finalPrice = model.price * (1 - model.discountPercentage / 100),
            discountPercentage = model. discountPercentage.takeIf { it > 0 },
            rating = model.rating,
            reviewsCount = model.reviews.size,
            availability = if (model.stock > 0)
                Availability.IN_STOCK else Availability.OUT_OF_STOCK,
            saleType = if (model.minimumOrderQuantity < 1)
                SaleType.WHOLESALE
            else
                SaleType.RETAIL(model.minimumOrderQuantity),
            stock = model.stock,
            tags = model.tags,
            images = model.images,
            thumbnail =model. thumbnail,
            shippingInfo = model.shippingInformation.takeIf { it.isNotBlank() },
            warrantyInfo = model.warrantyInformation.takeIf { it.isNotBlank() },
            returnPolicy = model.returnPolicy.takeIf { it.isNotBlank() }
        )

    }
