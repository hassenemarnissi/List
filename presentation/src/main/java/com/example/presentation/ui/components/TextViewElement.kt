package com.example.presentation.ui.components

import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

sealed class TextViewElement {
    data class StringResource(
        @StringRes
        val resId: Int,
        val args: List<Any> = emptyList()
    ) : TextViewElement()

    data class PluralResource(
        @PluralsRes val resId: Int,
        val quantity: Int,
        val args: List<Any> = emptyList()
    ) : TextViewElement()

    data class Dynamic(val value: String) : TextViewElement()
}