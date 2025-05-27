package com.example.elaborato_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.elaborato_mobile.ui.ShoppingNavGraph
import com.example.elaborato_mobile.ui.theme.Elaborato_MobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Elaborato_MobileTheme {
                val navController = rememberNavController()
                ShoppingNavGraph(navController)
            }
        }
    }
}




