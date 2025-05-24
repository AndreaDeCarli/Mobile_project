package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.composables.AddButton
import com.example.elaborato_mobile.ui.composables.BottomBar
import com.example.elaborato_mobile.ui.composables.LazyList
import com.example.elaborato_mobile.ui.composables.TopBar

@Composable
fun Favorites(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController,"Favorites") },
        bottomBar = { BottomBar(navController, 2) },
        floatingActionButton = { AddButton() }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            LazyList("Prodotto", 4)
        }
    }
}