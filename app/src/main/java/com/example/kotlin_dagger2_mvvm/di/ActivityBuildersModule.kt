package com.example.kotlin_dagger2_mvvm.di

import com.example.kotlin_dagger2_mvvm.AuthActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity() : AuthActivity

    companion object{
        @Provides
        fun someString() : String{
            return "Some String to understand what happen"
        }
    }
}