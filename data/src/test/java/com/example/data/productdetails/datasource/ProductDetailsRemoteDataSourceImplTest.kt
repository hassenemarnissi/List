package com.example.data.productdetails.datasource

import com.example.data.productdetails.api.ProductDetailsApi
import com.example.data.productdetails.fixture.ProductFixture
import com.example.data.productdetails.model.ProductModel
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
class ProductDetailsRemoteDataSourceImplTest {

    @Mock
    lateinit var productDetailsApi: ProductDetailsApi

    @InjectMocks
    lateinit var remoteDataSource: ProductDetailsRemoteDataSourceImpl

    @Test
    fun `getProductById return Success when api success`() = runTest {
        val productId = 1
        val expectedProduct: ProductModel = ProductFixture.productModel()

        `when`(productDetailsApi.getProductById(productId))
            .thenReturn(expectedProduct)

        val result = remoteDataSource.getProductById(productId)

        assertTrue(result is Success)
        assertEquals(expectedProduct, (result as Success).value)

        verify(productDetailsApi).getProductById(productId)
    }

    @Test
    fun `getProductById return Failure when api fail`() = runTest {
        val productId = 1

        `when`(productDetailsApi.getProductById(productId))
            .thenThrow(RuntimeException("API Error"))

        val result = remoteDataSource.getProductById(productId)

        assertTrue(result is Failure)
        assertEquals("[ProductDetailsRemoteDataSourceImpl::getProductById] An unexpected error occurred: API Error", (result as Failure).message)

        verify(productDetailsApi).getProductById(productId)
    }
}
