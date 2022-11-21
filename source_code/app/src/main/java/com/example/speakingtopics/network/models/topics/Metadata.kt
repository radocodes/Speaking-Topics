package com.example.speakingtopics.network.models.topics

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Metadata(
    @SerialName("name")
    val name: String,

    @SerialName("readCountRemaining")
    val readCountRemaining: Int,

    @SerialName("timeToExpire")
    val timeToExpire: Int,

    @SerialName("createdAt")
    val createdAt: String
)
