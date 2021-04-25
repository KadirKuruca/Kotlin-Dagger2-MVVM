package com.example.kotlin_dagger2_mvvm.ui.Auth

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class AuthViewModel @Inject constructor()  : ViewModel() {

    init {
        Log.e(TAG, "AuthViewModel: is creating and working")
    }
}