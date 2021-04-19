package com.example.kotlin_dagger2_mvvm

import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

const val TAG = "AuthActivity"

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var someString : String

    @set:[Inject Named("isAppNull")]
    var isAppNull: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Log.e(TAG, "onCreate: $someString")
        Log.e(TAG, "onCreate: is app null ? $isAppNull")
    }
}