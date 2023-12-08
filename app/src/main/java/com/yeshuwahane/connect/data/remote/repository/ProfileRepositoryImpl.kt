package com.yeshuwahane.connect.data.remote.repository

import com.yeshuwahane.connect.data.remote.ProfileApi
import com.yeshuwahane.connect.data.remote.dto.ProfileModel
import com.yeshuwahane.connect.domain.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(val api: ProfileApi):ProfileRepository {
    override suspend fun getAllProfile(): ProfileModel {
        return api.getProfiles()
    }
}