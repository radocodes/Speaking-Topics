package com.example.speakingtopics.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
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
                onNavigateToTopicDetails = { topicId ->
                    navController.navigate(Destination.TopicDetailsScreen.createRoute(topicId))
                },
                onNavigateToLibrary = {
                    navController.navigate((Destination.TopicLibraryScreen.route))
                }
            )
        }

        composable(
            route = Destination.TopicDetailsScreen.route,
            arguments = listOf(navArgument(Arguments.TOPIC_DETAIL_ID) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            val topicId = backStackEntry.arguments?.getInt(Arguments.TOPIC_DETAIL_ID)

            TopicDetailsScreen(topicId = topicId ?: 0)
        }

        composable(Destination.TopicLibraryScreen.route) {
            TopicLibraryScreen(
                onNavigateToTopicDetails = { topicId ->
                    navController.navigate(Destination.TopicDetailsScreen.createRoute(topicId))
                }
            )
        }
    }
}

object Arguments {
    const val TOPIC_DETAIL_ID = "topic_id"
}