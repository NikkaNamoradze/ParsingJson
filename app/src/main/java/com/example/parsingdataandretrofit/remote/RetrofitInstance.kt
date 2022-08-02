package com.example.parsingdataandretrofit.remote

import com.example.parsingdataandretrofit.BuildConfig
import com.example.parsingdataandretrofit.apiinterface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    val retrofitBuilder: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}