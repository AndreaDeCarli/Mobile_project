package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.elaborato_mobile.R
import com.example.elaborato_mobile.ui.ShopListState
import com.example.elaborato_mobile.ui.ShopListViewModel
import com.example.elaborato_mobile.ui.composables.AddButton
import com.example.elaborato_mobile.ui.composables.BottomBar
import com.example.elaborato_mobile.ui.composables.LazyList
import com.example.elaborato_mobile.ui.composables.NavBottomBar
import com.example.elaborato_mobile.ui.composables.TopBar


@Composable
fun Homepage (shopListState: ShopListState, navController: NavController, vm: ShopListViewModel) {
    Scaffold(
        topBar = { TopBar(navController, "Homepage") },
        bottomBar = { NavBottomBar(navController, 1) },
        floatingActionButton = { AddButton(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colorScheme.surface,

        ) {
            LazyList(shopListState, vm)
        }
    }
}