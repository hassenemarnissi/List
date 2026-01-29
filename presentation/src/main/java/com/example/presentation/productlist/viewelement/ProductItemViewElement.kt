package com.example.presentation.productlist.viewelement

import com.example.presentation.ui.components.TextViewElement


class ProductItemViewElement(
    val id: Int,
    val title: String,
    val brand: String?,
    val thumbnail: String?,
    val ratingText: String,
    val reviewsText: TextViewElement,
    val priceText: String,
    val discountText: String?,
    val availability:AvailabilityViewElement,
    val saleTypeLabel: TextViewElement
)