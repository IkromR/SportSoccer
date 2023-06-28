package com.radzhabov.sportsoccer.main.di

import com.radzhabov.sportsoccer.main.data.remote.FootballService
import com.radzhabov.sportsoccer.main.domain.usecase.GetFootballUseCase
import com.radzhabov.sportsoccer.main.data.repository.FootballRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FootballModule {

    @Singleton
    @Provides
    fun provideFootballRepository(footballService: FootballService): FootballRepository {
        return FootballRepository(footballService)
    }

    @Singleton
    @Provides
    fun provideGetFootballUseCase(footballRepository: FootballRepository): GetFootballUseCase {
        return GetFootballUseCase(footballRepository)
    }
}