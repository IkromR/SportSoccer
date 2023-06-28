package com.radzhabov.sportsoccer.main.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.radzhabov.sportsoccer.main.domain.item.FootballItem
import com.radzhabov.sportsoccer.main.presentation.viewmodel.MainViewModel

@Composable
fun MatchCard(
    mainViewModel: MainViewModel
) {

    val footballs by mainViewModel.football.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(size = 20.dp),
    ) {
        Card(
            modifier = Modifier
                .padding(15.dp)
                .shadow(
                    elevation = 8.dp,
                    ambientColor = Color.Black,
                    spotColor = Color.White
                ),
            shape = RoundedCornerShape(size = 15.dp),
        ) {
            LazyColumn {
                for (i in footballs.indices step 2) {
                    val firstTeam = footballs[i]
                    val secondTeam = footballs[i + 1]
                    item {
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Top,
                        ) {
                            FootballCard(firstTeam)

                            Text(text = "VS")

                            FootballCard(secondTeam)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FootballCard(
    football: FootballItem
) {
    val image = rememberImagePainter(data = football.country_logo)

    Card(
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
            Row {
                Column {
                    Text(text = football.country_name, overflow = TextOverflow.Ellipsis)
                }

                Spacer(modifier = Modifier.padding(30.dp))

                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .fillMaxWidth()
                        .size(50.dp)
                )
            }
        }
    }
}
