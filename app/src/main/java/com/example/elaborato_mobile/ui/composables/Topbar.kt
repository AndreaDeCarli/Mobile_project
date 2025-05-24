package com.example.elaborato_mobile.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import com.example.elaborato_mobile.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, title: String){
    TopAppBar(
        title = { Text(title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.dark_water_blue),
            titleContentColor = colorResource(R.color.dark_powder_blue),
            actionIconContentColor = colorResource(R.color.dark_powder_blue),
        ),
        actions = {
            IconButton( onClick = { TODO() }) {
                Icon(Icons.Filled.Settings, "Settings")
            }
        }
    )
}
