package com.example.speakingtopics.ui.navigation

sealed class Destination(val route: String, val title: String) {
    object HomeScreen : Destination("HomeScreen", "Home")

    object TopicDetailsScreen : Destination(
        "TopicDetailsScreen/{${Arguments.TOPIC_DETAIL_ID}}",
        "Topic Details"
    ) {
        fun createRoute(topicId: Int) = "TopicDetailsScreen/$topicId"
    }

    object TopicLibraryScreen : Destination("TopicLibraryScreen", "Library")
}