package com.asafin24.hammersystems_test_safin.data.repository

import com.asafin24.hammersystems_test_safin.domain.repository.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}