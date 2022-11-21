package com.example.speakingtopics.network.apiservice

import com.example.speakingtopics.network.models.topics.TopicResponseModel

interface ApiService {
    suspend fun getDefaultTopics(): List<TopicResponseModel>
}