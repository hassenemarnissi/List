package com.example.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.productlist.usecase.ProductListUseCase
import com.example.domain.result.Failure
import com.example.domain.result.Success
import com.example.presentation.productlist.mapper.ProductItemViewMapper
import com.example.presentation.productlist.state.ProductListUiState
import com.example.presentation.utils.DispatchersWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val dispatchers: DispatchersWrapper,
    private val useCase: ProductListUseCase,
    private val mapper : ProductItemViewMapper
    ): ViewModel(){
    private val _uiState = MutableStateFlow(value = ProductListUiState())
    val uiState: StateFlow<ProductListUiState> = _uiState

    init {
        loadProducts()
    }
    fun loadProducts() {
        if (_uiState.value.isLoading) return

        viewModelScope.launch(dispatchers.io()) {
            _uiState.update { it.copy(isLoading = true, error = null) }

            when (val result = useCase()) {
                is Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            products = (it.products) + (result.value.items).map { mapper.map(it) },
                            canLoadMore = result.value.canLoadMore
                        )
                    }
                }

                is Failure -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = result.message
                        )
                    }
                }
            }
        }
    }
    fun loadMore() {
        if (_uiState.value.canLoadMore) {
            loadProducts()
        }
    }
    fun retry() {
        if (_uiState.value.products.isEmpty()) {
            loadProducts()
        } else {
            loadMore()
        }
    }

}