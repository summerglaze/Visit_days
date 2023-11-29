package com.example.a30days

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30days.data.OneDay
import com.example.a30days.ui.theme.DaysAppTheme


@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun DaysList(
    days: List<OneDay>,
    modifier: Modifier = Modifier,
) {
    Scaffold( topBar = {
        DaysAppBar()
    }) {it ->
        LazyColumn(modifier = modifier, contentPadding = it) {
            itemsIndexed(days) { index, day ->
                DayItem(
                    day = day,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
fun PlaceInfo(
    @StringRes descriptionResId: Int,
    modifier: Modifier = Modifier
    ){
    Column(modifier = modifier) {
        Text(
            text = stringResource(descriptionResId),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun DayItem(day: OneDay, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth()){
        Column(){
            var isClicked by remember {mutableStateOf(false)}
            Text(text = stringResource(day.dayResId) + " " + day.dayNr.toString(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .align(alignment = Alignment.CenterHorizontally)
                )
            Text(text = stringResource(day.cityTopicId),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp),
                textAlign = TextAlign.Center)
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                //.background(Color.Red)
            ){
                Image(painter = painterResource(day.imageResId),
                    contentDescription = null,
                    modifier = Modifier.align(alignment = Alignment.Center)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable ( onClick = { isClicked= !isClicked} ),
                    contentScale = ContentScale.Fit
                )
            }
            if (isClicked) {
                //PlaceInfo(day.descriptionResId)
                //}
                Text(
                    text = stringResource(day.descriptionResId),
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Preview
@Composable
fun OneDayPreview(){
    val day = OneDay(R.string.day, 2, R.string.topic2, R.drawable.photo_2, R.string.description2)
        DaysAppTheme{
            DayItem(day = day)
        }
}