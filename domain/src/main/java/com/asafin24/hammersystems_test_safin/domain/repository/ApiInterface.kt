package com.asafin24.hammersystems_test_safin.domain.repository

import com.asafin24.hammersystems_test_safin.domain.models.RickMortyModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("api/character")
    suspend fun getMenu() : Response<RickMortyModel>

}