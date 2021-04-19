package com.example.kotlin_dagger2_mvvm.di

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    companion object{
        @Provides
        fun someString() : String{
            return "Some String to understand what happen"
        }

        @Provides
        fun getApp(application: Application) : Boolean{
            return application == null
        }
    }
}