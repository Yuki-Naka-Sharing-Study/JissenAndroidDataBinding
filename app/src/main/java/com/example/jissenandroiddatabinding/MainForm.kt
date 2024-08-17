package com.example.jissenandroiddatabinding

import android.content.Context
import android.widget.Toast
import androidx.databinding.BaseObservable

class MainForm: BaseObservable(){
    var to: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var subject: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var message: String = ""
        set(value) {
            field = value
            notifyChange()
        }

    var valid: Boolean = true
        set(value) {
            field = value
            notifyChange()
        }

    fun validate(context: Context) {
        valid = to.isNotBlank()
        if (valid) {
            send(context)
        }
    }

    private fun send(context: Context) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}