package com.example.jissenandroiddatabinding

import android.content.Context
import android.os.Looper
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

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
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            onComplete.postValue(true)
        }, 3000) // 適宜遅延時間を設定
    }
}