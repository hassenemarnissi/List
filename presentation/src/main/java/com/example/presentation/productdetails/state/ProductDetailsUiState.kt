package com.example.presentation.productdetails.state

import com.example.presentation.productdetails.viewelement.ProductDetailViewElement

sealed interface ProductDetailsUiState {
    data object Loading : ProductDetailsUiState
    data class Success(val product: ProductDetailViewElement) : ProductDetailsUiState
    data object Error : ProductDetailsUiState
}