package com.example.kotlin_dagger2_mvvm.ui.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kotlin_dagger2_mvvm.models.User
import com.example.kotlin_dagger2_mvvm.networking.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

private const val TAG2 = "AuthViewModel"
class AuthViewModel @Inject constructor(private val authApi: AuthApi)  : ViewModel() {

    private var authUser = MediatorLiveData<User>()

    init {
        Log.e(TAG2, "AuthViewModel: is creating and working")
    }

    fun authenticateWithId(userId : Int){
        val source : LiveData<User> = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(userId)
                .subscribeOn(Schedulers.io())
        )
        authUser.addSource(source, object : Observer<User> {
            override fun onChanged(t: User?) {
                authUser.value = t
                authUser.removeSource(source)
            }
        })
    }

    fun observeUser() : LiveData<User>{
        return authUser
    }
}