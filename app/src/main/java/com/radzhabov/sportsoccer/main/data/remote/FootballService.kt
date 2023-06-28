package com.radzhabov.sportsoccer.main.data.remote

import com.radzhabov.sportsoccer.main.data.remote.model.FootballModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class FootballService @Inject constructor (
    private val footballApi: FootballApi
) {

    suspend fun getFootball(): FootballModel =
        withContext(Dispatchers.IO) {
            val matches = footballApi.getFootball()
            matches.body() ?: FootballModel(
                result = emptyList(),
                success = 1
            )
        }

}