package com.example.speakingtopics.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speakingtopics.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    onNavigateToTopicDetails: (topicId: Int) -> Unit,
    onNavigateToLibrary: () -> Unit,
    viewModel: HomeVM = koinViewModel()
) {
// A surface container using the 'background' color from the theme
    Surface(
        modifier = modifier,
        color = MaterialTheme.colors.surface
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.home_header_board),
                contentDescription = stringResource(id = R.string.content_description_home_screen_header_image)
            )
            
            Text(
                text = stringResource(id = R.string.home_screen_header),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.green_milk_dark)),
                fontSize = dimensionResource(id = R.dimen.home_screen_txt_header_font_size).value.sp,
                textAlign = TextAlign.Center
            )

            if (viewModel.isLoading) {
                CircularProgressIndicator()
            } else {
                Button(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.home_screen_btn_padding))
                        .wrapContentSize(),
                    onClick = { onNavigateToTopicDetails(viewModel.randomTopicId) }
                ) {
                    Text(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.home_screen_btn_padding)),
                        text = stringResource(id = R.string.home_screen_txt_btn_random_topic),
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(id = R.dimen.home_screen_btn_txt_font_size).value.sp
                    )
                }

                Text(
                    text = stringResource(id = R.string.home_screen_txt_btn_separator),
                    fontSize = dimensionResource(id = R.dimen.home_screen_btn_txt_font_size).value.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )

                Button(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.home_screen_btn_padding))
                        .wrapContentSize(),
                    onClick = onNavigateToLibrary
                ) {
                    Text(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.home_screen_btn_padding)),
                        text = stringResource(id = R.string.home_screen_txt_btn_select_topic),
                        fontWeight = FontWeight.Bold,
                        fontSize = dimensionResource(id = R.dimen.home_screen_btn_txt_font_size).value.sp
                    )
                }
            }
        }
    }
}