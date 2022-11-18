package com.example.speakingtopics.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.speakingtopics.ui.components.CustomTopAppBar
import com.example.speakingtopics.ui.navigation.NavGraph
import com.example.speakingtopics.ui.theme.SpeakingTopicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            SpeakingTopicsTheme {

                val navController = rememberNavController()

                Scaffold(
                    topBar = {
                        CustomTopAppBar(navController = navController)
                    },
                    content = { NavGraph(navController) }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpeakingTopicsTheme {
        Greeting("Android")
    }
}