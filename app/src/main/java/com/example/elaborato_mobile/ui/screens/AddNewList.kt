package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.elaborato_mobile.ui.AddShopListActions
import com.example.elaborato_mobile.ui.AddShopListState
import com.example.elaborato_mobile.ui.composables.ConfirmButton
import com.example.elaborato_mobile.ui.composables.TopBar

@Composable
fun AddNewList (state: AddShopListState, actions: AddShopListActions, onSubmit: () -> Unit, navController: NavController){
    Scaffold (
        topBar = { TopBar(navController, "Add new List", true) },
        floatingActionButton = { FloatingActionButton(
            containerColor = MaterialTheme.colorScheme.tertiary,
            onClick = {
                if (!state.canSubmit) return@FloatingActionButton
                onSubmit()
                navController.navigateUp()
            }
        ) {
            Icon(Icons.Outlined.Check, "Add")
        } }
    ) { innerpadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerpadding)
        ) {

            OutlinedTextField(
                onValueChange = actions::setTitle,
                value = state.title,
                label = { Text("Title") },
                modifier = Modifier.padding(12.dp).fillMaxWidth())

            OutlinedTextField(
                onValueChange = actions::setDate,
                value = state.date,
                label = { Text("Date") },
                modifier = Modifier.padding(12.dp).fillMaxWidth())
        }
    }
}