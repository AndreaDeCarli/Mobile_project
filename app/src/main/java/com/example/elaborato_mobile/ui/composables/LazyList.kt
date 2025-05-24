package com.example.elaborato_mobile.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elaborato_mobile.R


@Composable
fun ListItem(string: String){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp, vertical = 4.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.dark_bluish_gray),
            contentColor = colorResource(R.color.light_gray_powder)
        )
    ) {
        Text(text = string, modifier = Modifier.padding(15.dp), fontSize = 20.sp)
        Text(text = "Prova prova deca è bello è un grande prova test della scritta ", modifier = Modifier.padding(15.dp))
    }
}

@Composable
fun ShoppingListCard(string: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(horizontal = 5.dp, vertical = 6.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.dark_bluish_gray),
            contentColor = colorResource(R.color.light_gray_powder)
        )
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier.fillMaxHeight().weight(0.25F),
                contentAlignment = Alignment.Center,
            ){
                Image(Icons.Outlined.Image,
                    "List picture",
                    colorFilter = ColorFilter.tint(colorResource(R.color.light_cool_gray)),
                    modifier = Modifier
                        .background(colorResource(R.color.dark_powder_blue))
                        .fillMaxSize()
                )
            }
            Column (
                modifier = Modifier.padding(horizontal = 5.dp).weight(0.65F)
            ) {
                Text(text = string, fontSize = 20.sp, modifier = Modifier.padding(5.dp), color = colorResource(R.color.light_cool_gray))
                Text(
                    text = "Details of the thing in the card",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(5.dp),
                    color = colorResource(R.color.blue_powder)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier.padding(horizontal = 3.dp, vertical = 12.dp).weight(0.1F),
                colors = IconButtonDefaults.iconButtonColors(containerColor = colorResource(R.color.dark_bluish_gray)),
            ) {
                Icon(Icons.Filled.MoreVert, "More")
            }
        }
    }
}

@Composable
fun LazyList(
    string: String,
    number: Int,
    modifier: Modifier = Modifier
){
    val elems = (0..number).map { "$string - $it" }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
    ) {
        items(elems.size) { index ->
            ShoppingListCard(elems[index])
        }
    }
}
