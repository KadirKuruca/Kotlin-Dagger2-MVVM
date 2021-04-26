package com.example.kotlin_dagger2_mvvm.networking.auth

import com.example.kotlin_dagger2_mvvm.models.User
import io.reactivex.Flowable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.Flow

interface AuthApi {

    @GET("users/{id}")
    fun getUser(@Path("id") id : Int) : Flowable<User>
}