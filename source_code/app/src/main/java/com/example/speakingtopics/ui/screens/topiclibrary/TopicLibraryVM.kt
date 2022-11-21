package com.example.speakingtopics.ui.screens.topiclibrary

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speakingtopics.data.repositories.TopicRepository
import com.example.speakingtopics.data.repositories.models.topics.TopicModel
import kotlinx.coroutines.launch

class TopicLibraryVM(topicRepository: TopicRepository) : ViewModel() {
    private val _allTopics = mutableStateListOf<TopicModel>()
    val allTopics: List<TopicModel>
        get() = _allTopics

    init {
        viewModelScope.launch {
            _allTopics.clear()
            _allTopics.addAll(topicRepository.getAllTopics())
        }
    }
}