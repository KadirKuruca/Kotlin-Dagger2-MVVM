package com.example.kotlin_dagger2_mvvm.di

import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_dagger2_mvvm.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(modelProviderFactory: ViewModelProviderFactory) : ViewModelProvider.Factory
}