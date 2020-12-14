package com.example.td

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.example.td.ui.TDTheme

class MainActivity : AppCompatActivity() {
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TDTheme {
                HomeScreen(cards = homeViewModel.cards)
            }
        }
    }
}