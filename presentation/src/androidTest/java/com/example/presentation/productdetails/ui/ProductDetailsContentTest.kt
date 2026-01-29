package com.example.presentation.productdetails.ui


import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText

import com.example.presentation.productdetails.viewelement.ProductDetailViewElement
import com.example.presentation.ui.components.TextViewElement
import org.junit.Rule
import org.junit.Test



class ProductDetailsContentTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun displays_all_fields() {
        val product = ProductDetailViewElement(
            id = 1,
            title = "title",
            brand = "brand",
            imageUrl = "",
            price = TextViewElement.Dynamic("price"),
            discount = TextViewElement.Dynamic("discount"),
            description = TextViewElement.Dynamic("description"),
            rating = TextViewElement.Dynamic("rating"),
            shippingInfo = TextViewElement.Dynamic("shipping"),
            warrantyInfo = TextViewElement.Dynamic("warranty"),
            returnPolicy = TextViewElement.Dynamic("return")
        )

        composeRule.setContent {
            CompositionLocalProvider(
                LocalInspectionMode provides true
            ) {
                ProductDetailsContent(product)
            }
        }

        composeRule.onNodeWithText("title").assertIsDisplayed()
        composeRule.onNodeWithText("brand").assertIsDisplayed()
        composeRule.onNodeWithText("price").assertIsDisplayed()
        composeRule.onNodeWithText("discount").assertIsDisplayed()
        composeRule.onNodeWithText("description").assertIsDisplayed()
        composeRule.onNodeWithText("shipping").assertIsDisplayed()
        composeRule.onNodeWithText("warranty").assertIsDisplayed()
        composeRule.onNodeWithText("return").assertIsDisplayed()
    }

    @Test
    fun hides_optional_fields_when_null() {
        val product = ProductDetailViewElement(
            id = 1,
            title = "title",
            brand = null,
            imageUrl = "",
            price = TextViewElement.Dynamic("price"),
            discount = null,
            description = TextViewElement.Dynamic("description"),
            rating = TextViewElement.Dynamic("rating"),
            shippingInfo = null,
            warrantyInfo = null,
            returnPolicy = null
        )

        composeRule.setContent {
            ProductDetailsContent(product)
        }

        composeRule.onNodeWithText("title").assertIsDisplayed()
        composeRule.onNodeWithText("price").assertIsDisplayed()
        composeRule.onNodeWithText("description").assertIsDisplayed()

        composeRule.onNodeWithText("shipping").assertDoesNotExist()
        composeRule.onNodeWithText("warranty").assertDoesNotExist()
        composeRule.onNodeWithText("return").assertDoesNotExist()
    }
}
