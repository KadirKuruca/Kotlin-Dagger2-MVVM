package com.example.kotlin_dagger2_mvvm.ui.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kotlin_dagger2_mvvm.models.User
import com.example.kotlin_dagger2_mvvm.networking.auth.AuthApi
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(authApi: AuthApi)  : ViewModel() {

    init {
        Log.e(TAG, "AuthViewModel: is creating and working")

        authApi.getUser(1)
                .toObservable()
                .subscribeOn(Schedulers.io())
                .subscribe(object : Observer<User> {
                    override fun onSubscribe(d: Disposable?) {
                    }

                    override fun onNext(value: User?) {
                        Log.e(TAG, "onNext: "+value?.email )
                    }

                    override fun onError(e: Throwable?) {
                        Log.e(TAG, "onError: "+e.toString())
                    }

                    override fun onComplete() {
                        
                    }

                })
    }
}