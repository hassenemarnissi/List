package com.example.presentation.productlist.state

import com.example.presentation.productlist.viewelement.ProductItemViewElement

data class ProductListUiState(
    val isLoading: Boolean = false,
    val products: List<ProductItemViewElement> = emptyList(),
    val canLoadMore: Boolean = false,
    val error: String? = null
)