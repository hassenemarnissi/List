package com.example.presentation.productdetails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.presentation.R
import com.example.presentation.productdetails.ProductDetailsViewModel
import com.example.presentation.productdetails.state.ProductDetailsUiState
import com.example.presentation.ui.components.ErrorOverlay
import com.example.presentation.ui.components.LoadingOverlay

@Composable
fun ProductDetailsScreen(
    productId: Int,
    viewModel: ProductDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(productId) {
        viewModel.load(productId)
    }
    Box(
        modifier = Modifier
            .background(colorScheme.background)
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())){
    when (val value = state) {
        ProductDetailsUiState.Loading -> LoadingOverlay()

        ProductDetailsUiState.Error ->
            ErrorOverlay(stringResource(R.string.load_error)) { viewModel.load(productId) }


        is ProductDetailsUiState.Success -> {
            ProductDetailsContent(
                product = value.product
            )
        }
    }
        }
}
