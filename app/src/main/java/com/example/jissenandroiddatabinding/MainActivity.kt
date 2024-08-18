package com.example.jissenandroiddatabinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.jissenandroiddatabinding.databinding.ActivityMainBinding

// 続き 第4章 Build GitHub Search Repos App
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val form = MainForm()
        form.onComplete.observe(this, Observer {
            Toast.makeText(this, "送信しました。", Toast.LENGTH_SHORT).show()
            finish()
        })
        binding.form = form
    }

}