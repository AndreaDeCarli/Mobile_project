package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.composables.AddButton
import com.example.elaborato_mobile.ui.composables.BottomBar
import com.example.elaborato_mobile.ui.composables.LazyList
import com.example.elaborato_mobile.ui.composables.NavBottomBar
import com.example.elaborato_mobile.ui.composables.TopBar

@Composable
fun Favorites(navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController,"Favorites") },
        bottomBar = { NavBottomBar(navController, 2) },
        floatingActionButton = { AddButton(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.padding(innerPadding),
            color = MaterialTheme.colorScheme.surface,

            ) {
        }
    }
}