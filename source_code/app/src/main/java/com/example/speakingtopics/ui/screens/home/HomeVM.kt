package com.example.speakingtopics.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speakingtopics.data.repositories.TopicRepository
import com.example.speakingtopics.data.repositories.models.topics.TopicModel
import kotlinx.coroutines.launch

class HomeVM(topicRepository: TopicRepository) : ViewModel() {
    private val _allTopics = mutableStateListOf<TopicModel>()

    val randomTopicId: Int
        get() = _allTopics.random().id

    var isLoading by mutableStateOf(false)

    init {
        viewModelScope.launch {
            isLoading = true
            _allTopics.clear()
            _allTopics.addAll(topicRepository.getAllTopics())
            isLoading = false
        }
    }
}