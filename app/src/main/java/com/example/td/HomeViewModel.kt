package com.example.td

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.td.remote.CardDetail
import com.example.td.remote.HomePageApi
import kotlinx.coroutines.launch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class HomeViewModel : ViewModel() {
    var cards: List<CardDetail> by mutableStateOf(listOf())
        private set

    init {
        viewModelScope.launch {
            cards = HomePageApi.retrofitService.getCards().page.cards
        }
    }
}