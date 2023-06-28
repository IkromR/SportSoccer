package com.radzhabov.sportsoccer.main.data.repository

import com.radzhabov.sportsoccer.main.data.remote.FootballService
import com.radzhabov.sportsoccer.main.domain.item.FootballItem
import com.radzhabov.sportsoccer.main.domain.item.toFootballItem
import javax.inject.Inject

class FootballRepository @Inject constructor(
    private val footballService: FootballService
){

    suspend fun getFootball(): List<FootballItem> =
        footballService.getFootball().toFootballItem()

}