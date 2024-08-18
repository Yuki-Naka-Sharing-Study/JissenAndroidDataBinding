package com.example.jissenandroiddatabinding

import android.content.Context
import android.os.Looper
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

typealias ObservableString = ObservableField<String>

class MainForm: BaseObservable(){

    val to = ObservableField<String>("")
    val subject = ObservableField<String>("")
    val message = ObservableField<String>("")
    val valid = ObservableBoolean(true)
    val requesting = ObservableBoolean()

    val onComplete = MutableLiveData<Boolean>()

    fun validate(context: Context) {
        val result = !to.get().isNullOrBlank()
        valid.set(result)
        if (result) {
            requesting.set(true)
            send()
        }
    }

    private fun send() {
        Api.client.postSample().enqueue(object : retrofit2.Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {}
            override fun onResponse(call: Call<String>, response: Response<String>) {
                onComplete.postValue(true)
            }
        })
    }
}