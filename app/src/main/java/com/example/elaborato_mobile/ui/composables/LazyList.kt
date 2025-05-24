package com.example.elaborato_mobile.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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
fun LazyList(string: String, number: Int){
    val elems = (0..number).map { "$string - $it" }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(elems.size) { index ->
            ListItem(elems[index])
        }
    }
}
