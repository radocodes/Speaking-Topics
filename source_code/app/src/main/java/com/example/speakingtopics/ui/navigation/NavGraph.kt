package com.example.speakingtopics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.speakingtopics.ui.screens.home.HomeScreen
import com.example.speakingtopics.ui.screens.topicdetails.TopicDetailsScreen

@Composable
fun NavGraph(
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ) {
        composable(Destination.HomeScreen.route) {
            HomeScreen(
                onNavigateToTopicDetails = {
                    navController.navigate(Destination.TopicDetailsScreen.route)
                }
            )
        }
        composable(Destination.TopicDetailsScreen.route) {
            TopicDetailsScreen()
        }
    }
}