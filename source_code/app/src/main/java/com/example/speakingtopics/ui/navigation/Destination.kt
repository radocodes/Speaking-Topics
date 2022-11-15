package com.example.speakingtopics.ui.navigation

import com.example.speakingtopics.ui.activities.Greeting

sealed class Destination(val route: String, val title: String) {
    object HomeScreen : Destination("HomeScreen", "Home")
    object TopicDetailsScreen : Destination("TopicDetailsScreen", "Topic Details")
}