package com.example.elaborato_mobile.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun AddButton(){
    FloatingActionButton(
        onClick = { TODO() },
        containerColor = MaterialTheme.colorScheme.secondary,
        elevation = FloatingActionButtonDefaults.elevation()
    ) {
        Icon(Icons.Filled.Add, "Add")
    }
}