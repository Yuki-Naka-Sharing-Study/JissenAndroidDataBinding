package com.example.jissenandroiddatabinding

import android.content.Context
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

typealias ObservableString = ObservableField<String>

class MainForm: BaseObservable(){

    val to = ObservableField<String>("")
    val subject = ObservableField<String>("")
    val message = ObservableField<String>("")
    val errorMessage = ObservableField<String>()

    fun validate(context: Context) {
        val result = !to.get().isNullOrBlank()
        val error = if (result) null else "宛先を必ず指定してください。"

        errorMessage.set(error)

        if (result) {
            send(context)
        }
    }

    private fun send(context: Context) {
        Toast.makeText(context, message.get(), Toast.LENGTH_SHORT).show()
    }
}