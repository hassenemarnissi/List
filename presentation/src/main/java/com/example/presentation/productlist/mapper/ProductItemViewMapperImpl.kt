package com.example.presentation.productlist.mapper

import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.ProductEntity
import com.example.domain.productlist.entity.SaleType
import com.example.presentation.R
import com.example.presentation.productlist.uitext.formatters.toPriceText
import com.example.presentation.productlist.viewelement.AvailabilityViewElement
import com.example.presentation.productlist.viewelement.AvailabilityViewElementStyle
import com.example.presentation.productlist.viewelement.ProductItemViewElement
import com.example.presentation.ui.components.TextViewElement
import javax.inject.Inject

class ProductItemViewMapperImpl @Inject constructor() : ProductItemViewMapper {
    override fun map(entity: ProductEntity): ProductItemViewElement =
        ProductItemViewElement(
            id = entity.id,
            title = entity.title,
            brand = entity.brand,
            thumbnail = entity.thumbnail,
            ratingText = "%.1f".format(entity.rating),
            reviewsText = TextViewElement.PluralResource(
                resId = R.plurals.reviews_count,
                quantity = entity.reviewsCount,
                args = listOf(entity.reviewsCount)
            ),
            priceText = entity.finalPrice.toPriceText(),
            discountText = entity.discountPercentage
                .takeIf { it > 0 }
                ?.let { "-${it.toInt()}%" },
            availability = map(entity.availability),
            saleTypeLabel = map(entity.saleType)
        )


    private fun map(availability: Availability): AvailabilityViewElement =
        when (availability) {
            Availability.IN_STOCK -> AvailabilityViewElement(
                label = TextViewElement.StringResource(R.string.in_stock),
                style = AvailabilityViewElementStyle.Positive
            )

            Availability.OUT_OF_STOCK -> AvailabilityViewElement(
                label = TextViewElement.StringResource(R.string.out_stock),
                style = AvailabilityViewElementStyle.Negative
            )
        }

    private fun map(saleType: SaleType): TextViewElement =
        when (saleType) {
            is SaleType.RETAIL -> TextViewElement.StringResource(R.string.retail)
            SaleType.WHOLESALE -> TextViewElement.StringResource(R.string.wholesale)
        }

}