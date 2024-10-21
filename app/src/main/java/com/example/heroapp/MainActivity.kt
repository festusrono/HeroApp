package com.example.heroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.heroapp.model.HeroesRepository
import com.example.heroapp.ui.theme.HeroAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeroAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    HeroApp()
                }
            }
        }
    }
}
//composable to display an app bar and a list of heroes.
@Composable
fun HeroApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        //important:it  is not a good practise to access data source directly from the UI
        //later we will use ViewModel to modify the data source
        val heroes = HeroesRepository.heroes
        HeroesList(heroes = heroes, contentPadding = it)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource("HeroApp"),
                style = MaterialTheme.typography.displayLarge,
            )
        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun HeroAppPreview() {
    HeroAppTheme {
        HeroApp()
    }
}