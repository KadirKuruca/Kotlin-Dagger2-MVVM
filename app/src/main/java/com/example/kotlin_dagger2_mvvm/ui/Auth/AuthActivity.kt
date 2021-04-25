package com.example.kotlin_dagger2_mvvm.ui.Auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.kotlin_dagger2_mvvm.R
import com.example.kotlin_dagger2_mvvm.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

const val TAG = "AuthActivity"

class AuthActivity : DaggerAppCompatActivity() {

    private lateinit var viewModel : AuthViewModel

    @Inject
    lateinit var providerFactory : ViewModelProviderFactory

    @Inject
    lateinit var logo : Drawable

    @Inject
    lateinit var requestManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()
    }

    private fun setLogo(){
        requestManager.
        load(logo).into(login_logo)
    }
}