package com.radzhabov.sportsoccer.main.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radzhabov.sportsoccer.main.domain.item.FootballItem
import com.radzhabov.sportsoccer.main.domain.usecase.GetFootballUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
    private val getFootballUseCase: GetFootballUseCase
): ViewModel() {

    private val _football = MutableStateFlow(emptyList<FootballItem>())
    val football: StateFlow<List<FootballItem>> get() = _football

    init {
        getFootball()
    }

    private fun getFootball() {
        viewModelScope.launch {
            try {
                val football = getFootballUseCase()
                _football.value = football
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error getting football data", e)
            }
        }
    }
}