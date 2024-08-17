package com.example.jissenandroiddatabinding

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("showError", "errorText")
fun EditText.setErrorText(showError: Boolean, errorText: String) {
    error = if (showError) errorText else null
}