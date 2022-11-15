package com.example.speakingtopics.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speakingtopics.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    onNavigateToTopicDetails: () -> Unit,
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
                contentDescription = "Home Header Board"
            )
            
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(id = R.color.green_milk_dark)),
                text = "Improve Your Speech",
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )

            Button(
                modifier = Modifier
                    .padding(32.dp)
                    .wrapContentSize(),
                onClick = onNavigateToTopicDetails
            ) {
                Text(
                    modifier = Modifier.padding(32.dp),
                    text = "Get Random Topic",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }

            Text(
                text = "or",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )

            Button(
                modifier = Modifier
                    .padding(32.dp)
                    .wrapContentSize(),
                onClick = { /*TODO: implement */ }
            ) {
                Text(
                    modifier = Modifier.padding(32.dp),
                    text = "Select Topic",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
        }
    }
}