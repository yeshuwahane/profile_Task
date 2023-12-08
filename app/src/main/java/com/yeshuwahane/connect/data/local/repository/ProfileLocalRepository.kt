package com.yeshuwahane.connect.data.local.repository

import com.yeshuwahane.connect.data.local.ProfileDao
import com.yeshuwahane.connect.data.local.entity.toEntity
import com.yeshuwahane.connect.data.remote.dto.Data
import javax.inject.Inject


class ProfileLocalRepository @Inject constructor(
    val profileDao: ProfileDao
){

    suspend fun getAllProfile()= profileDao.getAllProfile()

    suspend fun addToFavorite(profileModel: Data){
        profileDao.addProfile(profileModel.toEntity())
    }

    suspend fun remoteProfile(profileModel: Data){
        profileDao.removeProfile(profileModel.toEntity())
    }
}