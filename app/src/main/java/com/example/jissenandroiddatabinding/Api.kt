package com.example.jissenandroiddatabinding

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST

interface ApiEndpoint {
    @POST("postSample")
    fun postSample(): Call<String>
}

object Api {
    val client: ApiEndpoint = Retrofit.Builder()
        // アクセス先のURLは各自で用意とのことなので、Web系エンジニアの学習部屋から引用
        .baseUrl("https://qiita.com/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(ApiEndpoint::class.java)
}