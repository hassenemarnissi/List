package com.example.presentation.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.productdetails.usecase.ProductDetailsUseCase
import com.example.domain.result.Failure
import com.example.domain.result.Success
import com.example.presentation.productdetails.mapper.ProductDetailViewMapper
import com.example.presentation.productdetails.state.ProductDetailsUiState
import com.example.presentation.utils.DispatchersWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val dispatchers: DispatchersWrapper,
    private val useCase: ProductDetailsUseCase,
    private val mapper: ProductDetailViewMapper
) : ViewModel() {
    private val _uiState = MutableStateFlow<ProductDetailsUiState>(ProductDetailsUiState.Loading)
    val uiState: StateFlow<ProductDetailsUiState> = _uiState

    fun load(productId: Int) {
        viewModelScope.launch(dispatchers.io()) {
            _uiState.value = ProductDetailsUiState.Loading
            when(val result = useCase(productId)){
                is Success -> _uiState.value = ProductDetailsUiState.Success(mapper.map(result.value))
                is Failure -> _uiState.value = ProductDetailsUiState.Error
            }
        }
    }
}