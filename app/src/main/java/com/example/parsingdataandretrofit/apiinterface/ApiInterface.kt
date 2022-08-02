package com.example.parsingdataandretrofit.apiinterface

import com.example.parsingdataandretrofit.molel.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("3588163c-a9c8-488c-af9a-534b392e7128")
    suspend fun getData(): Response<Product>
}