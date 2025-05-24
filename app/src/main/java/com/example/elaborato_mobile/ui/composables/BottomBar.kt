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
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.ShoppingRoute


@Composable
fun BottomBar(navController: NavController, active: Int){
    BottomAppBar (
        containerColor = MaterialTheme.colorScheme.primaryContainer,
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
            IconButton( onClick = {}, modifier = Modifier.padding(20.dp)) {
                if (active == 3){
                    Icon(Icons.Filled.AccountCircle, "Profile")
                }else{
                    Icon(Icons.Outlined.AccountCircle, "Profile")
                }
            }
        }
    }
}