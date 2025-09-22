package com.example.tp1_dev_mob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.tp1_dev_mob.ui.theme.TP1_Dev_MobTheme
class Destination1
class Destination2
class Destination3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP1_Dev_MobTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val backStack= remember { mutableStateListOf<Any>(Destination1()) }
                    NavDisplay(
                        backStack = backStack,
                        entryProvider = entryProvider {
                            entry<Destination1>{
                                EvenementPage(
                                    interrese = {backStack.add(Destination2())},
                                    pas_interrese = {backStack.add(Destination3())}
                                )
                            }
                            entry<Destination2>{Inscription( )}
                            entry<Destination3>{Desole()}

                        }
                    )

                    }
                }
            }
        }
    }



