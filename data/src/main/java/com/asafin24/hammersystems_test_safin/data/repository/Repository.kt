package com.asafin24.hammersystems_test_safin.data.repository

import com.asafin24.hammersystems_test_safin.domain.models.RickMortyModel
import retrofit2.Response

class Repository {
    suspend fun getMenu() : Response<RickMortyModel> {
        return RetrofitInstance.api.getMenu()
    }
}