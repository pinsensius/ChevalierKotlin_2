package com.example.tugascheva2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tugascheva2.ui.theme.TugasCheva2Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TugasCheva2Theme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Chevalier Lab",
                                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                                        )
                                },
                                colors = TopAppBarDefaults.mediumTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    titleContentColor = MaterialTheme.colorScheme.secondary
                                )
                            )
                    }
                ) {paddingValues ->
                    Greeting(modifier = Modifier.padding(paddingValues))

                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
                text = "Division",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold),
                color = MaterialTheme.colorScheme.primary
            )

        DivisionCard(
            imageSrc = R.drawable.android,
            title = "Android Divison",
            description = "Divisi dalam Chevalier Lab yang bekerja dengan lingkungan Android"
        )

        DivisionCard(
            imageSrc = R.drawable.startup,
            title = "Start-Up Division",
            description = "Divisi dalam Chevalier Lab yang bekerja dengan lingkup Start-Up"
        )

        DivisionCard(
            imageSrc = R.drawable.web,
            title = "Web Division",
            description = "Divisi dalam Chevalier Lab yang bekerja dengan lingkup Web"
        )

        DivisionCard(
            imageSrc = R.drawable.game,
            title = "Game Division",
            description = "Divisi dalam Chevalier Lab yang bekerja dengan lingkup game"
        )

        DivisionCard(
            imageSrc = R.drawable.uiux,
            title = "UI/UX Division",
            description = "Division dalam Chevalier Lab yang bekerja dengan lingkup UI/UX")
    }
}

@Composable
fun DivisionCard(
    imageSrc : Int,
    title : String,
    description : String,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(10.dp, RoundedCornerShape(16.dp)),
        shape = RoundedCornerShape(16.dp),
        elevation = androidx.compose.material3.CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                painter = painterResource(id = imageSrc),
                contentDescription = null
            )
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Medium),
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal),
                color = MaterialTheme.colorScheme.onSurface
            )



        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TugasCheva2Theme {
        Greeting()
    }
}