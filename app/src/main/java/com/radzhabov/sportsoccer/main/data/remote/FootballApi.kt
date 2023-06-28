package com.radzhabov.sportsoccer.main.data.remote

import com.radzhabov.sportsoccer.main.data.remote.model.FootballModel
import com.radzhabov.sportsoccer.main.domain.utils.Constants.Companion.FOOTBALL_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface FootballApi {

    @GET(FOOTBALL_ENDPOINT)
    suspend fun getFootball(): Response<FootballModel>

}