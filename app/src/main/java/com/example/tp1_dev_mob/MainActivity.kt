package com.example.tp1_dev_mob

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tp1_dev_mob.ui.theme.TP1_Dev_MobTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Evenements()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Evenements(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Evènements") },
                navigationIcon = {
                    IconButton(onClick = { /* Action icône gauche */ }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Action icône droite */ }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorie")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Image
            Image(
                painter = painterResource(id = R.drawable.image_evenement), // mets ton image ici
                contentDescription = "Mon image",
                modifier = Modifier
                    .size(450.dp)
                    .padding(bottom = 16.dp)
            )

            // Ligne de texte 1
            Text(
                text = "Où : Ecole ingénieur ISIS",
                fontSize = 20.sp,
                textAlign = TextAlign.Start
            )

            // Ligne de texte 2
            Text(
                text = "Quand : 24 octobre",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Start,
            )

            // Deux boutons côte à côte
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 20.dp)

            ) {
                Button(onClick = { /* Action 1 */ }) {
                    Text("Inscription")
                }
                Button(onClick = { /* Action 2 */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.onPrimary, // fond = couleur du texte normal
                        contentColor = MaterialTheme.colorScheme.primary       // texte = couleur du fond normal
                    )
                ) {
                    Text("Pas intéressé")
                }
            }
        }
    }
}

