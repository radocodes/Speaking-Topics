package com.example.speakingtopics.data.repositories

import com.example.speakingtopics.data.repositories.models.topics.TopicModel
import com.example.speakingtopics.network.apiservice.ApiService

class TopicRepositoryImpl(private val apiService: ApiService) : TopicRepository {

    private val _allDefaultTopicsCached = mutableListOf<TopicModel>()

    private suspend fun getAllDefaultTopicsCached(): MutableList<TopicModel> {
        if (_allDefaultTopicsCached.isEmpty()) {
            fetchAllDefaultTopics()
        }
        return _allDefaultTopicsCached
    }

    override suspend fun getTopicById(topicId: Int): TopicModel? {
        return getAllDefaultTopicsCached().firstOrNull { topic -> topic.id == topicId }
    }

    override suspend fun getAllTopics(): List<TopicModel> = getAllDefaultTopicsCached()

    private suspend fun fetchAllDefaultTopics() {
        _allDefaultTopicsCached.clear()

        apiService.getDefaultTopics().forEach { item ->
            _allDefaultTopicsCached.add(TopicModel(item.id, item.topic, item.hints))
        }
    }
}