package com.example.presentation.productdetails

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productdetails.usecase.ProductDetailsUseCase
import com.example.domain.result.Failure
import com.example.domain.result.Success
import com.example.presentation.productdetails.mapper.ProductDetailViewMapper
import com.example.presentation.productdetails.state.ProductDetailsUiState
import com.example.presentation.productdetails.viewelement.ProductDetailViewElement
import com.example.presentation.utils.DispatchersWrapper
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductDetailsViewModelTest {

    @Mock
    private lateinit var dispatchersWrapper: DispatchersWrapper

    @Mock
    private lateinit var useCase: ProductDetailsUseCase

    @Mock
    private lateinit var mapper: ProductDetailViewMapper

    @InjectMocks
    private lateinit var viewModel: ProductDetailsViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcher = UnconfinedTestDispatcher()


    @Test
    fun `load should emit Success state when use case success`() = runTest {
        val productId = 1
        val entity = mock<ProductDetailEntity>()
        val viewElement = mock<ProductDetailViewElement>()
        `when`(dispatchersWrapper.io()).thenReturn(dispatcher)
        `when`(useCase(productId)).thenReturn(Success(entity))
        `when`(mapper.map(entity)).thenReturn(viewElement)

        viewModel.load(productId)

        val state = viewModel.uiState.value

        assertTrue(state is ProductDetailsUiState.Success)
        assertEquals(viewElement, (state as ProductDetailsUiState.Success).product)

        verify(useCase).invoke(productId)
        verify(mapper).map(entity)
    }

    @Test
    fun `load should emit Error state when use case fail`() = runTest {
        val productId = 1
        `when`(dispatchersWrapper.io()).thenReturn(dispatcher)

        `when`(useCase(productId)).thenReturn(Failure("error"))

        viewModel.load(productId)

        val state = viewModel.uiState.value

        assertEquals(ProductDetailsUiState.Error, state)
        verify(useCase).invoke(productId)
        verifyNoInteractions(mapper)
    }


}
