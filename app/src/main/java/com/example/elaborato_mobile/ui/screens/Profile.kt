package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.composables.BottomBar
import com.example.elaborato_mobile.ui.composables.TopBar

@Composable
fun Profile(navController: NavController){
    Scaffold(
        topBar = { TopBar(navController, "Profilo") },
        bottomBar = { BottomBar(navController, 3) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Text("Profilo")
        }
    }
}