package com.example.domain.productlist.entity

sealed class SaleType {
    data class RETAIL(val minimumOrderQuantity: Int) : SaleType()
    data object WHOLESALE : SaleType()
}