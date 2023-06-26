package com.radzhabov.sportsoccer.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MatchCard() {
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
            Text(text = "Home Screen")
        }
    }

}
