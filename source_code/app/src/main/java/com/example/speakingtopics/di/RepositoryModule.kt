package com.example.speakingtopics.di

import com.example.speakingtopics.data.repositories.TopicRepository
import com.example.speakingtopics.data.repositories.TopicRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<TopicRepository> { TopicRepositoryImpl(get()) }
}