package com.example.elaborato_mobile.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elaborato_mobile.ui.screens.Favorites
import com.example.elaborato_mobile.ui.screens.Homepage
import kotlinx.serialization.Serializable

sealed interface ShoppingRoute {
    @Serializable data object Home : ShoppingRoute
    @Serializable data object Favorites : ShoppingRoute
}

@Composable
fun ShoppingNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = ShoppingRoute.Home
    ) {
        composable<ShoppingRoute.Home> {
            Homepage(navController)
        }
        composable<ShoppingRoute.Favorites> {
            Favorites(navController)
        }
    }
}