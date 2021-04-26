package com.example.kotlin_dagger2_mvvm.di.auth

import androidx.lifecycle.ViewModel
import com.example.kotlin_dagger2_mvvm.di.ViewModelKey
import com.example.kotlin_dagger2_mvvm.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AuthViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel) : ViewModel
}