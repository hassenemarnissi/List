package com.example.data.productlist.model

import com.example.data.productdetails.model.ProductModel

data class ProductsResponseModel(
    val products: List<ProductModel>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
