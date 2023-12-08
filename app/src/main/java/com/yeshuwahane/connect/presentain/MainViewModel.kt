package com.yeshuwahane.connect.presentain

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeshuwahane.connect.data.local.repository.ProfileLocalRepository
import com.yeshuwahane.connect.data.remote.dto.Data
import com.yeshuwahane.connect.data.remote.dto.toData
import com.yeshuwahane.connect.domain.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: ProfileRepository,
    val localProfileRepository: ProfileLocalRepository
):ViewModel() {

    val remoteData:MutableState<List<Data>> by lazy {
        mutableStateOf(emptyList())
    }
    val localData:MutableState<List<Data>> by lazy {
        mutableStateOf(emptyList())
    }

    val showToastLiveData:MutableLiveData<String> = MutableLiveData()


    //remote data
    fun getRemoteData(){
        viewModelScope.launch {
            val data = repository.getAllProfile()
            remoteData.value = data.data
        }
    }

    //local database
    fun getLocalData(){
        viewModelScope.launch {
            val data = localProfileRepository.getAllProfile()
            localData.value = data.map {
                it.toData()
            }
        }
    }

    fun addToFavorite(profileData:Data){
        viewModelScope.launch {
            localProfileRepository.addToFavorite(profileData)
        }
    }

    fun removeFromFavorite(profileData: Data){
        viewModelScope.launch{
            localProfileRepository.remoteProfile(profileData)
        }
    }

    fun showToast(value:String){
        showToastLiveData.value = value

    }

}