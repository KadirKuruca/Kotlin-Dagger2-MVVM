package com.example.kotlin_dagger2_mvvm.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kotlin_dagger2_mvvm.networking.auth.AuthApi
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi)  : ViewModel() {

    init {
        Log.e(TAG, "AuthViewModel: is creating and working")

        if(authApi == null)
            Log.e(TAG, "AuthViewModel: auth api is null" )
        else
            Log.e(TAG, "AuthViewModel: auth api is not null" )
    }
}