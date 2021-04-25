package com.example.kotlin_dagger2_mvvm.di

import com.example.kotlin_dagger2_mvvm.di.auth.AuthViewModelsModule
import com.example.kotlin_dagger2_mvvm.ui.Auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [AuthViewModelsModule::class]
    )
    abstract fun contributeAuthActivity() : AuthActivity
}