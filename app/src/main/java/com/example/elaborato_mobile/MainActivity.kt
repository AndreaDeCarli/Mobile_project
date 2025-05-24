package com.example.elaborato_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elaborato_mobile.ui.theme.Elaborato_MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Elaborato_MobileTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = {BottomBar()},
                    floatingActionButton = {AddButton()}
                ) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        LazyList()
                    }

                }
            }
        }
    }
}


@Composable
fun BottomBar(){
    BottomAppBar (
        containerColor = MaterialTheme.colorScheme.primaryContainer,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            var active by remember { mutableStateOf(1) }
            IconButton( onClick = {active = 1}, modifier = Modifier.padding(20.dp)) {
                if (active == 1){
                    Icon(Icons.Filled.Home, "Home")
                }else{
                    Icon(Icons.Outlined.Home, "Home")
                }
            }
            IconButton( onClick = {active = 2}, modifier = Modifier.padding(20.dp)) {
                if (active == 2){
                    Icon(Icons.Filled.Favorite, "Favorite")
                }else{
                    Icon(Icons.Outlined.FavoriteBorder, "Favorite")
                }
            }
            IconButton( onClick = {active = 3}, modifier = Modifier.padding(20.dp)) {
                if (active == 3){
                    Icon(Icons.Filled.AccountCircle, "Profile")
                }else{
                    Icon(Icons.Outlined.AccountCircle, "Profile")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        title = { Text("Main page") },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        actions = {
            IconButton( onClick = { TODO() }) {
                Icon(Icons.Filled.Settings, "Settings")
            }
        }
    )
}


@Composable
fun ListItem(string: String){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 4.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
    ) {
        Text(text = string, modifier = Modifier.padding(15.dp), fontSize = 20.sp)
        Text(text = "Prova prova deca è bello è un grande prova test della scritta ", modifier = Modifier.padding(15.dp))
    }
}

@Composable
fun LazyList(){
    val elems = (0..10).map { "Lista $it" }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(elems.size) { index ->
            ListItem(elems[index])
        }
    }
}

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