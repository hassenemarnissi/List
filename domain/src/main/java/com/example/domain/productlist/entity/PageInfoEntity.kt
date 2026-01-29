package com.example.domain.productlist.entity

data class PageInfoEntity(
    val totalItems: Int,
    val offset: Int,
    val limit: Int
) {
    fun hasNext(): Boolean = offset + limit < totalItems
}
