package com.radzhabov.sportsoccer.main.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.radzhabov.sportsoccer.project.presentation.theme.DarkOrange
import com.radzhabov.sportsoccer.main.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkOrange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Sport Soccer",
            style = MaterialTheme.typography.bodyLarge,
        )

        Spacer(modifier = Modifier.padding(8.dp))


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

                MatchCard(mainViewModel)
            }
        }
    }
}