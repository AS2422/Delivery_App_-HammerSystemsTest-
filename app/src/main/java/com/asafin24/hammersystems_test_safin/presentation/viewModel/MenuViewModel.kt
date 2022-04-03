package com.asafin24.hammersystems_test_safin.presentation.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.asafin24.hammersystems_test_safin.data.repository.Repository
import com.asafin24.hammersystems_test_safin.domain.models.RickMortyModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MenuViewModel(application: Application): AndroidViewModel(application) {

    val repository = Repository()
    val menuList: MutableLiveData<Response<RickMortyModel>> = MutableLiveData()

    fun getMenu() {
        viewModelScope.launch {
            menuList.value = repository.getMenu()
        }
    }

}