package com.example.data.productdetails.repository

import com.example.data.productdetails.datasource.ProductDetailsRemoteDataSource
import com.example.data.productdetails.fixture.ProductFixture
import com.example.data.productdetails.mapper.ProductDetailsMapper
import com.example.data.productdetails.model.ProductModel
import com.example.domain.productdetails.entity.ProductDetailEntity
import com.example.domain.result.Failure
import com.example.domain.result.Success
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductDetailsRepositoryImplTest {

    @Mock
    lateinit var remoteDataSource: ProductDetailsRemoteDataSource

    @Mock
    lateinit var productDetailsMapper: ProductDetailsMapper

    @InjectMocks
    lateinit var repository: ProductDetailsRepositoryImpl

    @Test
    fun `getProductById return mapped entity when remote success`() = runTest {
        val productId = 1
        val productModel: ProductModel = ProductFixture.productModel()
        val expectedValue: ProductDetailEntity = ProductFixture.productDetailsEntity()
        `when`(remoteDataSource.getProductById(productId))
            .thenReturn(Success(productModel))

        `when`(productDetailsMapper.map(productModel))
            .thenReturn(expectedValue)

        val result = repository.getProductById(productId)

        assertTrue(result is Success)

        assertEquals(expectedValue, (result as Success).value)

        verify(remoteDataSource).getProductById(productId)
        verify(productDetailsMapper).map(productModel)
    }

    @Test
    fun `getProductById return Failure when remote fail`() = runTest {
        val productId = 1
        val failure = Failure("API Error")

        `when`(remoteDataSource.getProductById(productId))
            .thenReturn(failure)

        val result = repository.getProductById(productId)

        assertTrue(result is Failure)
        assertEquals("API Error", (result as Failure).message)

        verify(remoteDataSource).getProductById(productId)
    }
}
