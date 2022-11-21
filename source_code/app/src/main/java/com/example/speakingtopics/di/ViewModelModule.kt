package com.example.speakingtopics.di

import com.example.speakingtopics.ui.screens.home.HomeVM
import com.example.speakingtopics.ui.screens.topicdetails.TopicDetailsVM
import com.example.speakingtopics.ui.screens.topiclibrary.TopicLibraryVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TopicDetailsVM(get()) }

    viewModel { TopicLibraryVM(get()) }

    viewModel { HomeVM(get()) }
}