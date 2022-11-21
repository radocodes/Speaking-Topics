package com.example.speakingtopics.ui.screens.topiclibrary

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speakingtopics.R
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TopicLibraryScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    viewModel: TopicLibraryVM = koinViewModel(),
    onNavigateToTopicDetails: (topicId: Int) -> Unit,
) {

    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.surface
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Image(
                    painterResource(id = R.drawable.library_img),
                    contentDescription = "Topic library header board"
                )
            }

            item {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Select topic:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                )
            }

            items(viewModel.allTopics) { item ->
                Card(
                    modifier = modifier

                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { },
                    elevation = 10.dp,
                    backgroundColor = colorResource(id = R.color.green_milk_dark),
                    onClick = { onNavigateToTopicDetails(item.id) }
                ) {
                    Column(
                        modifier = modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            modifier = modifier,
                            text = item.topic
                        )
                    }
                }
            }
        }
    }
}