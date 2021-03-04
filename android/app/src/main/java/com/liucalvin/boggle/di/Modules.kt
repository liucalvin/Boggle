package com.liucalvin.boggle.di

import com.liucalvin.boggle.ui.gameplay.GameViewModel
import com.liucalvin.boggle.ui.history.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameFragmentModule = module {

    viewModel { GameViewModel() }

}

val historyFragmentModule = module {
    viewModel { HistoryViewModel() }
}