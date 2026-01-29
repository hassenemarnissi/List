package com.example.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.productdetails.ui.ProductDetailsScreen
import com.example.presentation.productlist.ui.ProductListScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "productList"
    ) {
        composable("productList") {
            ProductListScreen(
                onProductClick = { productId ->
                    navController.navigate("productDetails/$productId")
                }
            )
        }

        composable(
            route = "productDetails/{productId}",
            arguments = listOf(
                navArgument("productId") { type = NavType.IntType }
            )
        ) {
            val productId = it.arguments?.getInt("productId") ?: return@composable
            ProductDetailsScreen(productId = productId)
        }
    }
}


