package com.example.domain.productlist.entity.listing

data class Listing<T>(
    val items: List<T>,
    val canLoadMore: Boolean
)