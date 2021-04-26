package com.example.kotlin_dagger2_mvvm.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.kotlin_dagger2_mvvm.R
import com.example.kotlin_dagger2_mvvm.models.User
import com.example.kotlin_dagger2_mvvm.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

const val TAG = "AuthActivity"

class AuthActivity : DaggerAppCompatActivity(), View.OnClickListener{

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

        login_button.setOnClickListener(this)

        setLogo()

        subscribeObservers()
    }

    private fun subscribeObservers(){
        viewModel.observeUser().observe(this, object : Observer<User> {
            override fun onChanged(user: User?) {
                if (user != null)
                    Log.e(TAG, "onChanged: " + user.email )
            }
        })
    }

    private fun setLogo(){
        requestManager.
        load(logo).into(login_logo)
    }

    override fun onClick(view: View?) {
        when(view){
            login_button -> attemptLogin()
        }
    }

    private fun attemptLogin() {
        if(TextUtils.isEmpty(user_id_input.text.toString()))
            return
        val userId = user_id_input.text.toString()
        viewModel.authenticateWithId(userId.toInt())
    }
}