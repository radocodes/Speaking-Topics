package com.example.speakingtopics.network.apiservice

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

object HttpClientProvider {
    fun provide(): HttpClient {
        return HttpClient(OkHttp) {
            // Logging
            install(Logging) {
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json()
            }
        }
    }
}