package com.radzhabov.sportsoccer.main.domain.usecase

import com.radzhabov.sportsoccer.main.domain.item.FootballItem
import com.radzhabov.sportsoccer.main.data.repository.FootballRepository
import javax.inject.Inject

class GetFootballUseCase @Inject constructor(
    private val footballRepository: FootballRepository
) {
    suspend operator fun invoke(): List<FootballItem> =
        footballRepository.getFootball().shuffled()
}