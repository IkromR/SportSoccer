package com.radzhabov.sportsoccer.main.domain.item

import com.radzhabov.sportsoccer.main.data.remote.model.FootballModel

data class FootballItem (
    val country_name: String,
    val country_iso2: String,
    val country_logo: String
)

fun FootballModel.toFootballItem(): List<FootballItem> {
    return this.result.map { result ->
        FootballItem(
            country_name = result.country_name,
            country_iso2 = result.country_iso2,
            country_logo = result.country_logo
        )
    }
}
