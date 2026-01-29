package com.example.domain.productdetails

import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.productdetails.repository.ProductDetailsRepository
import com.example.domain.productdetails.usecase.ProductDetailsUseCaseImpl
import com.example.domain.result.Failure
import com.example.domain.result.Success
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductDetailsUseCaseImplTest {
    @Mock
    lateinit var repository: ProductDetailsRepository

    @InjectMocks
    lateinit var useCase: ProductDetailsUseCaseImpl
    @Test
    fun `invoke should return Success when repository success`() = runTest {
        val productId = 1
        val expectedEntity = mock<ProductDetailEntity>()
        val expectedResult = Success(expectedEntity)
        `when`(repository.getProductById(productId))
            .thenReturn(expectedResult)

        val result = useCase(productId)

        assertTrue(result is Success)
        assertEquals(expectedEntity, (result as Success).value)
        verify(repository).getProductById(productId)
    }

    @Test
    fun `invoke should return Failure when repository fail`() = runTest {
        val productId = 1
        val exception = RuntimeException("Repository error")
        val expectedResult = Failure(exception.message)

        `when`(repository.getProductById(productId)).thenReturn(expectedResult)

        val result = useCase(productId)

        assertTrue(result is Failure)
        assertEquals(exception.message, (result as Failure).message)
        verify(repository).getProductById(productId)
    }

}