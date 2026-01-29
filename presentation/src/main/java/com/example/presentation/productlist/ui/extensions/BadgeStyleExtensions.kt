package com.example.presentation.productlist.ui.extensions

import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.presentation.productlist.viewelement.AvailabilityViewElement
import com.example.presentation.productlist.viewelement.AvailabilityViewElementStyle

@Composable
fun AvailabilityViewElement.toBadgeColors() = AssistChipDefaults.assistChipColors(
    containerColor = when (this.style) {
        AvailabilityViewElementStyle.Positive ->
            MaterialTheme.colorScheme.primaryContainer

        AvailabilityViewElementStyle.Negative ->
            MaterialTheme.colorScheme.errorContainer
    },
    labelColor = when (this.style) {
        AvailabilityViewElementStyle.Positive ->
            MaterialTheme.colorScheme.onPrimaryContainer

        AvailabilityViewElementStyle.Negative ->
            MaterialTheme.colorScheme.onErrorContainer
    }
)
