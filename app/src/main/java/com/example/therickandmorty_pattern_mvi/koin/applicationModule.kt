package com.example.therickandmorty_pattern_mvi.koin

import com.example.therickandmorty_pattern_mvi.BuildConfig
import com.example.therickandmorty_pattern_mvi.data.managers.PersonManagerImpl
import com.example.therickandmorty_pattern_mvi.data.services.ApiService
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single {

        val okHttpClient = OkHttpClient.Builder()
            .cache(null)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        val gson: Gson = get()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BaseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single {
        PersonManagerImpl(get())
    }
}