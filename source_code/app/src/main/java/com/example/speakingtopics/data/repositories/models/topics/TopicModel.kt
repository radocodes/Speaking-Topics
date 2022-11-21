package com.example.speakingtopics.data.repositories.models.topics

data class TopicModel(
    val id: Int,
    val topic: String,
    val hints: List<String>
)
