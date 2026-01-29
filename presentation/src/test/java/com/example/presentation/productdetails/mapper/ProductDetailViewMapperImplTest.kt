package com.example.presentation.productdetails.mapper

import com.example.presentation.productdetails.ProductDetailsFixture
import com.example.presentation.ui.components.TextViewElement
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner
import com.example.presentation.R

@RunWith(MockitoJUnitRunner::class)
class ProductDetailViewMapperImplTest {

    @InjectMocks
    private lateinit var mapper: ProductDetailViewMapperImpl

    @Test
    fun `map should convert ProductDetailEntity to ProductDetailViewElement`() {
        val entity = ProductDetailsFixture.productDetailEntity()

        val result = mapper.map(entity)

        assertEquals(1, result.id)
        assertEquals("title", result.title)
        assertEquals("brand", result.brand)
        assertEquals("https://thumbnail", result.imageUrl)

        assertTrue(result.price is TextViewElement.Dynamic)
        assertEquals("999,99 €", (result.price as TextViewElement.Dynamic).value)

        assertTrue(result.discount is TextViewElement.StringResource)
        val discount = result.discount as TextViewElement.StringResource
        assertEquals(R.string.discount_percent, discount.resId)
        assertEquals(listOf(20), discount.args)

        assertTrue(result.description is TextViewElement.Dynamic)
        assertEquals(
            "description",
            (result.description as TextViewElement.Dynamic).value
        )

        assertTrue(result.rating is TextViewElement.StringResource)
        val rating = result.rating as TextViewElement.StringResource
        assertEquals(R.string.rating_value, rating.resId)
        assertEquals(listOf(4.7), rating.args)

        assertEquals(
            "in 48h",
            (result.shippingInfo as TextViewElement.Dynamic).value
        )

        assertEquals(
            "1 an",
            (result.warrantyInfo as TextViewElement.Dynamic).value
        )

        assertEquals(
            "30 jours",
            (result.returnPolicy as TextViewElement.Dynamic).value
        )
    }

    @Test
    fun `map should handle null optional value`() {
        val entity = ProductDetailsFixture.productDetailEntity().copy(
            discountPercentage = null,
            shippingInfo = null,
            warrantyInfo = null,
            returnPolicy = null
        )

        val result = mapper.map(entity)

        assertNull(result.discount)
        assertNull(result.shippingInfo)
        assertNull(result.warrantyInfo)
        assertNull(result.returnPolicy)
    }

}
