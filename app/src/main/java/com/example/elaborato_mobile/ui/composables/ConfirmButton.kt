package com.example.elaborato_mobile.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.AddShopListState

@Composable
fun ConfirmButton(state: AddShopListState,navController: NavController){
    FloatingActionButton(onClick = {navController.navigateUp()}) {
        Icon(Icons.Filled.Check, "Confirm")
    }
}