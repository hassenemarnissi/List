package com.example.presentation.productlist.uitext.formatters

import java.util.Locale

fun Double.toPriceText(
    currency: String = "€"
): String =
    String.format(Locale.getDefault(), "%.2f %s", this, currency)
