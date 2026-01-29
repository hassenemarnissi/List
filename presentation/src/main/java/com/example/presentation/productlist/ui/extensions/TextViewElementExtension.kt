package com.example.presentation.productlist.ui.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import com.example.presentation.ui.components.TextViewElement

@Composable
fun TextViewElement.resolve(): String =
    when (this) {
        is TextViewElement.Dynamic -> value
        is TextViewElement.StringResource ->
            stringResource(resId, *args.toTypedArray())

        is TextViewElement.PluralResource ->
            pluralStringResource(
            resId,
            quantity,
            *args.toTypedArray()
        )
    }