package com.example.kotlin_dagger2_mvvm.di.auth

import com.example.kotlin_dagger2_mvvm.networking.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    companion object{
        @Provides
        fun provideAuthApi(retrofit: Retrofit) : AuthApi {
            return retrofit.create(AuthApi::class.java)
        }
    }
}