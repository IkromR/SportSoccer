package com.radzhabov.sportsoccer.main.data.remote.model

data class FootballModel(
    val result: List<Result>,
    val success: Int
)

data class Result(
    val country_iso2: String,
    val country_key: String,
    val country_logo: String,
    val country_name: String
)