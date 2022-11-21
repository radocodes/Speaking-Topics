package com.example.speakingtopics.data.repositories

import com.example.speakingtopics.data.repositories.models.topics.TopicModel

interface TopicRepository {

    suspend fun getAllTopics(): List<TopicModel>

    suspend fun getTopicById(topicId: Int): TopicModel?
}