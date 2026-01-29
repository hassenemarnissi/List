package com.example.presentation.productdetails.viewelement

import com.example.presentation.ui.components.TextViewElement

data class ProductDetailViewElement(
    val id: Int,
    val title: String,
    val brand: String?,
    val imageUrl: String?,
    val price: TextViewElement,
    val discount: TextViewElement?,
    val description: TextViewElement,
    val rating: TextViewElement?,
    val shippingInfo: TextViewElement?,
    val warrantyInfo: TextViewElement?,
    val returnPolicy: TextViewElement?
)