package com.example.data.productdetails.mapper

import com.example.data.productdetails.fixture.ProductFixture
import com.example.domain.productlist.entity.Availability
import com.example.domain.productlist.entity.SaleType
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductDetailsMapperImplTest {

    @InjectMocks
    private lateinit var mapper: ProductDetailsMapperImpl

    @Test
    fun `map should correctly map ProductModel to ProductDetailEntity`() {
        val model = ProductFixture.productModel()

        val result = mapper.map(model)

        assertEquals(1, result.id)
        assertEquals("title", result.title)
        assertEquals("description", result.description)
        assertEquals("category", result.category)
        assertEquals("Brand", result.brand)
        assertEquals(99.99, result.price, 0.0)
        assertEquals(89.99, result.finalPrice, 0.01)
        assertEquals(10.0, result.discountPercentage)
        assertEquals(4.3, result.rating, 0.0)
        assertEquals(0, result.reviewsCount)
        assertEquals(Availability.IN_STOCK, result.availability)
        assertEquals(SaleType.RETAIL(1), result.saleType)
        assertEquals(10, result.stock)
        assertEquals(listOf("tag1", "tag2"), result.tags)
        assertEquals(0, result.images.size)
        assertEquals("https://thumbnail", result.thumbnail)
        assertEquals("Ships in 48h", result.shippingInfo)
        assertEquals("2 years", result.warrantyInfo)
        assertEquals("30 days", result.returnPolicy)
    }

    @Test
    fun `map should handle empty and optional value`() {
        val model = ProductFixture.productModel().copy(
            tags = emptyList(),
            brand = "",
            discountPercentage = 0.0,
            warrantyInformation = "",
            shippingInformation = "",
            reviews = emptyList(),
            returnPolicy = "",
            stock = 0,
            minimumOrderQuantity = 0

        )

        val result = mapper.map(model)

        assertNull(result.brand)
        assertNull(result.discountPercentage)
        assertNull(result.shippingInfo)
        assertNull(result.warrantyInfo)
        assertNull(result.returnPolicy)
        assertEquals(Availability.OUT_OF_STOCK, result.availability)
        assertEquals(SaleType.WHOLESALE, result.saleType)
    }

}
