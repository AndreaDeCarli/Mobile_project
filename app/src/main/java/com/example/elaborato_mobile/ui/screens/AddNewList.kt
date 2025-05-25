package com.example.elaborato_mobile.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.elaborato_mobile.ui.composables.TopBar

@Composable
fun AddNewList (navController: NavController){
    Scaffold (
        topBar = { TopBar(navController, "Add new List", true) }
    ) { innerpadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerpadding)
        ) {
            var title by remember { mutableStateOf("") }
            OutlinedTextField(
                onValueChange = {value -> title = value},
                value = title,
                label = { Text("Title") },
                modifier = Modifier.padding(12.dp).fillMaxWidth())
        }
    }
}