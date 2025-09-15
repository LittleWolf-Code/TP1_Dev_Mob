package com.example.tp1_dev_mob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.tp1_dev_mob.ui.theme.TP1_Dev_MobTheme
import androidx.compose.material3.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "Evenements"
            ) {
                composable("Evenements") { Evenements(navController) }
                composable("Inscription") { Inscription(navController) }
                composable("Desole") { Desole(navController) }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evenements(navController: NavController){
    Scaffold(
        topBar = {
            MyTopBar(title = "Evènements")
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.image_evenement), // mets ton image ici
                contentDescription = "Affiche évènement",
                modifier = Modifier
                    .fillMaxWidth(0.92f)
                    .aspectRatio(3f / 4f), // ratio d’affiche; ajuste si besoin
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.height(100.dp))

            Text(
                text = "Où : Ecole ingénieur ISIS",
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )


            Text(
                text = "Quand : 24 octobre",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Start,
            )

            Spacer(Modifier.height(85.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 20.dp)

            ) {
                Button(onClick = { navController.navigate("Inscription")}) {
                    Text("Inscription")
                }
                Button(onClick = { navController.navigate("Desole") },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary, // fond = couleur du texte normal
                        contentColor = MaterialTheme.colorScheme.primary,

                        // texte = couleur du fond normal
                    )
                ) {
                    Text("Pas intéressé")
                }
            }
        }
    }
}

