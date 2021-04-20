package com.example.kotlin_dagger2_mvvm.di

import com.example.kotlin_dagger2_mvvm.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity() : AuthActivity
}