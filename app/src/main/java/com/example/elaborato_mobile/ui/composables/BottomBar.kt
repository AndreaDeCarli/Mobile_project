package com.example.elaborato_mobile.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elaborato_mobile.R
import com.example.elaborato_mobile.ui.ShoppingRoute


@Composable
fun BottomBar(navController: NavController, active: Int){
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton( onClick = {
                navController.navigate(ShoppingRoute.Home)
                                  }, modifier = Modifier.padding(20.dp)) {
                if (active == 1){
                    Icon(Icons.Filled.Home, "Home")
                }else{
                    Icon(Icons.Outlined.Home, "Home")
                }
            }
            IconButton( onClick = {
                navController.navigate(ShoppingRoute.Favorites)
                                  }, modifier = Modifier.padding(20.dp)) {
                if (active == 2){
                    Icon(Icons.Filled.Favorite, "Favorite")
                }else{
                    Icon(Icons.Outlined.FavoriteBorder, "Favorite")
                }
            }
            IconButton( onClick = {
                navController.navigate(ShoppingRoute.Profile)
            }, modifier = Modifier.padding(20.dp)) {
                if (active == 3){
                    Icon(Icons.Filled.AccountCircle, "Profile")
                }else{
                    Icon(Icons.Outlined.AccountCircle, "Profile")
                }
            }
        }
    }
}

@Composable
fun NavBottomBar(navController: NavController, active: Int){
    NavigationBar (
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        NavigationBarItem(
            onClick = { navController.navigate(ShoppingRoute.Home) },
            selected =  active == 1 ,
            icon = { Icon(Icons.Outlined.Home, "Home") }
        )
        NavigationBarItem(
            onClick = { navController.navigate(ShoppingRoute.Favorites) },
            selected =  active == 2 ,
            icon = { Icon(Icons.Outlined.FavoriteBorder, "Favorite") }
        )
        NavigationBarItem(
            onClick = { navController.navigate(ShoppingRoute.Profile) },
            selected =  active == 3 ,
            icon = { Icon(Icons.Outlined.AccountCircle, "Profile") }
        )
    }
}