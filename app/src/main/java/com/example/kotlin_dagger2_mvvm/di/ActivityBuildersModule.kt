package com.example.kotlin_dagger2_mvvm.di

import com.example.kotlin_dagger2_mvvm.di.auth.AuthModule
import com.example.kotlin_dagger2_mvvm.di.auth.AuthViewModelsModule
import com.example.kotlin_dagger2_mvvm.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            AuthViewModelsModule::class,
            AuthModule::class
        ]
    )
    abstract fun contributeAuthActivity() : AuthActivity
}