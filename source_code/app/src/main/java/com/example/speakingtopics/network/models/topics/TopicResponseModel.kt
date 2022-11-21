package com.example.speakingtopics.network.models.topics

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicResponseModel(
    @SerialName("id")
    val id: Int,

    @SerialName("topic")
    val topic: String,

    @SerialName("hints")
    val hints: List<String>
)
