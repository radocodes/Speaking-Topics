package com.example.speakingtopics.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.speakingtopics.ui.navigation.Destination

@Composable
fun CustomTopAppBar(
    modifier: Modifier = Modifier.fillMaxWidth(),
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    var appBarArrowBackVisible by remember {
        mutableStateOf(false)
    }
    var appBarTitle by remember {
        mutableStateOf("")
    }

    navBackStackEntry?.destination?.route?.let {
        appBarArrowBackVisible = it != Destination.HomeScreen.route
        appBarTitle = it
    }

    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = appBarTitle,
                color = Color.White
            )
        },
        backgroundColor = Color.Black,
        navigationIcon = {
            if (appBarArrowBackVisible)
                IconButton(
                    modifier = modifier.wrapContentSize(),
                    onClick = navController::navigateUp,
                ) {
                    Icon(Icons.Outlined.ArrowBack, "Navigate Back", tint = Color.White)
                }
        }
    )
}