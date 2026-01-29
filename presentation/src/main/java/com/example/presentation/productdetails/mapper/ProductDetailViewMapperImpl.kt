package com.example.presentation.productdetails.mapper

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.presentation.R
import com.example.presentation.productdetails.viewelement.ProductDetailViewElement
import com.example.presentation.productlist.uitext.formatters.toPriceText
import com.example.presentation.ui.components.TextViewElement
import javax.inject.Inject

class ProductDetailViewMapperImpl @Inject constructor() : ProductDetailViewMapper {

    override fun map(entity: ProductDetailEntity): ProductDetailViewElement {

        val priceText = entity.finalPrice.toPriceText()

        val discountText = entity.discountPercentage?.let {
                TextViewElement.StringResource(
                    resId = R.string.discount_percent,
                    args = listOf(it.toInt())
                )
            }

        return ProductDetailViewElement(
            id = entity.id,
            title = entity.title,
            brand = entity.brand,
            imageUrl = entity.thumbnail,
            price = TextViewElement.Dynamic(priceText),
            discount = discountText,
            description = TextViewElement.Dynamic(entity.description),

            rating = TextViewElement.StringResource(
                resId = R.string.rating_value,
                args = listOf(entity.rating)
            ),

            shippingInfo = entity.shippingInfo?.let {
                TextViewElement.Dynamic(it)
            },

            warrantyInfo = entity.warrantyInfo?.let {
                TextViewElement.Dynamic(it)
            },

            returnPolicy = entity.returnPolicy?.let {
                TextViewElement.Dynamic(it)
            }
        )
    }
}
