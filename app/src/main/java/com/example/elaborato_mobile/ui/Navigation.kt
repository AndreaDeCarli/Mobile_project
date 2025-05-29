package com.example.elaborato_mobile.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.elaborato_mobile.ui.screens.AddNewList
import com.example.elaborato_mobile.ui.screens.Favorites
import com.example.elaborato_mobile.ui.screens.Homepage
import com.example.elaborato_mobile.ui.screens.Profile
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

sealed interface ShoppingRoute {
    @Serializable data object Home : ShoppingRoute
    @Serializable data object Favorites : ShoppingRoute
    @Serializable data object Profile : ShoppingRoute
    @Serializable data object AddNewList : ShoppingRoute
}

@Composable
fun ShoppingNavGraph(navController: NavHostController) {
    val shopListVm = koinViewModel<ShopListViewModel>()
    val shopListState by shopListVm.state.collectAsStateWithLifecycle()
    NavHost(navController = navController,
        startDestination = ShoppingRoute.Home
    ) {
        composable<ShoppingRoute.Home> {
            Homepage(shopListState,navController, shopListVm)
        }
        composable<ShoppingRoute.Favorites> {
            Favorites(navController)
        }
        composable<ShoppingRoute.Profile> {
            Profile(navController)
        }
        composable<ShoppingRoute.AddNewList> {
            val addShopListVm = koinViewModel<AddShopListViewModel>()
            val state by addShopListVm.state.collectAsStateWithLifecycle()
            AddNewList(
                state,
                addShopListVm.actions,
                onSubmit = { shopListVm.addShopList(state.toShopList()) },
                navController
            )
        }
    }
}