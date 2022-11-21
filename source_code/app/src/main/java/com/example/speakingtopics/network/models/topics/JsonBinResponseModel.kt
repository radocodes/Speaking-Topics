package com.example.speakingtopics.network.models.topics

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class JsonBinResponseModel(
    @SerialName("id")
    val id: String,

    @SerialName("record")
    val record: List<TopicResponseModel>,

    @SerialName("metadata")
    val metadata: Metadata
)

