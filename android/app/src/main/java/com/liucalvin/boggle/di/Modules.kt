package com.liucalvin.boggle.di

import com.liucalvin.boggle.db.GameDatabase
import com.liucalvin.boggle.repository.GameRepository
import com.liucalvin.boggle.repository.GameRepositoryImpl
import com.liucalvin.boggle.ui.gameplay.GameViewModel
import com.liucalvin.boggle.ui.history.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val gameFragmentModule = module {
    viewModel { GameViewModel(get()) }
}

val historyFragmentModule = module {
    viewModel { HistoryViewModel() }
}

val repositoryModule = module {
    single<GameRepository> { GameRepositoryImpl(get()) }
}

val databaseModule = module {
    single { GameDatabase.getInstance(get()) }
}