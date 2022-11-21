package com.example.speakingtopics.di

import com.example.speakingtopics.network.apiservice.ApiService
import com.example.speakingtopics.network.apiservice.ApiServiceImpl
import com.example.speakingtopics.network.apiservice.HttpClientProvider
import org.koin.dsl.module

val networkModule = module {
    single <ApiService> { ApiServiceImpl(HttpClientProvider.provide()) }
}