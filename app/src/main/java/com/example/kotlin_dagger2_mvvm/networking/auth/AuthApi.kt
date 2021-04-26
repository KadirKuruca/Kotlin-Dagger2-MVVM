package com.example.kotlin_dagger2_mvvm.networking.auth

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface AuthApi {

    @GET
    fun getFakeStuff() : Call<ResponseBody>
}