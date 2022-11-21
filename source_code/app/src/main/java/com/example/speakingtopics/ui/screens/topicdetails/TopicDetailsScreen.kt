package com.example.speakingtopics.ui.screens.topicdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speakingtopics.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopicDetailsScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: TopicDetailsVM = koinViewModel(),
    topicId: Int
) {

    val topic = viewModel.topic.observeAsState()

    viewModel.loadTopicById(topicId)

    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.surface
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painterResource(id = R.drawable.microphone_scene_img),
                    contentDescription = "Home Header Board"
                )
            }

            topic.value?.let {

                item {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.secondary)
                            .padding(vertical = 32.dp),
                        text = it.topic,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                    )
                }

                item {
                    Button(
                        modifier = Modifier
                            .padding(32.dp)
                            .wrapContentSize(),
                        shape = RoundedCornerShape(32.dp),
                        onClick = { /* TODO: implement */ }
                    ) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            text = "Start Timer",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp
                        )
                    }
                }

                items(it.hints) { hint ->
                    Text(text = hint)
                }
            }
        }
    }
}