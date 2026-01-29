package com.example.presentation.productdetails.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.presentation.productlist.ui.InfoBadge
import com.example.presentation.R
import com.example.presentation.productdetails.viewelement.ProductDetailViewElement
import com.example.presentation.productlist.ui.extensions.resolve

@Composable
fun ProductDetailsContent(
    product: ProductDetailViewElement,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        item {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
        }

        item {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    modifier = Modifier.semantics { heading() },
                    text = product.title,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                product.brand?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        item {
            Row(
               modifier = Modifier.semantics(mergeDescendants = true) {},
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.price.resolve(),
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                product.discount?.let { safeDiscount->
                        InfoBadge(
                            text = safeDiscount.resolve() ,
                            backgroundColor = MaterialTheme.colorScheme.inversePrimary,
                            contentColor = MaterialTheme.colorScheme.inverseSurface
                        )
                }
            }
        }

        item {
            Text(
                text = product.description.resolve(),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }

        product.shippingInfo?.let {safeShippingInfo->
            item {
                InfoSection(
                    title = stringResource(R.string.shipping),
                    value = safeShippingInfo.resolve()
                )
            }
        }

        product.warrantyInfo?.let {safeWarrantyInfo->
            item {
                InfoSection(
                    title = stringResource(R.string.warranty),
                    value = safeWarrantyInfo.resolve()
                )
            }
        }

        product.returnPolicy?.let {safeReturnPolicy->
            item {
                InfoSection(
                    title = stringResource(R.string.return_policy),
                    value = safeReturnPolicy.resolve()
                )
            }
        }
    }
}



