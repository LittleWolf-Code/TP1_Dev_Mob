package com.example.tp1_dev_mob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tp1_dev_mob.ui.theme.TP1_Dev_MobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP1_Dev_MobTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "evenement") {
                        composable("evenement") {
                            EvenementPage(navController = navController)
                        }
                        composable("inscription") {
                            Inscription(navController = navController)
                        }
                        composable("desole") {
                            Desole(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
