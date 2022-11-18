package com.example.speakingtopics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.speakingtopics.ui.screens.home.HomeScreen
import com.example.speakingtopics.ui.screens.topicdetails.TopicDetailsScreen
import com.example.speakingtopics.ui.screens.topiclibrary.TopicLibraryScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ) {
        composable(Destination.HomeScreen.route) {
            HomeScreen(
                onNavigateToTopicDetails = {
                    navController.navigate(Destination.TopicDetailsScreen.route)
                },
                onNavigateToLibrary = {
                    navController.navigate((Destination.TopicLibraryScreen.route))
                }
            )
        }
        composable(Destination.TopicDetailsScreen.route) {
            TopicDetailsScreen()
        }
        composable(Destination.TopicLibraryScreen.route) {
            TopicLibraryScreen()
        }
    }
}