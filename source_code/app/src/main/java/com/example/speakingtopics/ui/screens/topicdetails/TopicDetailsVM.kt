package com.example.speakingtopics.ui.screens.topicdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.speakingtopics.data.repositories.TopicRepository
import com.example.speakingtopics.data.repositories.models.topics.TopicModel
import kotlinx.coroutines.launch

class TopicDetailsVM(private val topicRepository: TopicRepository) : ViewModel() {

    var topic = MutableLiveData<TopicModel?>(null)

    fun loadTopicById(topicId: Int) {
        viewModelScope.launch {
            topic.value = topicRepository.getTopicById(topicId)
        }
    }
}