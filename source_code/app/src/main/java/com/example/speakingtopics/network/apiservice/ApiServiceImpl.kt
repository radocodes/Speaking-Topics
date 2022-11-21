package com.example.speakingtopics.network.apiservice

import com.example.speakingtopics.network.ApiRoutes
import com.example.speakingtopics.network.models.topics.JsonBinResponseModel
import com.example.speakingtopics.network.models.topics.TopicResponseModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiServiceImpl(private val httpClient: HttpClient) : ApiService {
    override suspend fun getDefaultTopics(): List<TopicResponseModel> {
        val result = httpClient.get(ApiRoutes.ALL_DEFAULT_TOPICS).body<JsonBinResponseModel>()
        return result.record
    }
}