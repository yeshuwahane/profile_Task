package com.yeshuwahane.connect.domain

import com.yeshuwahane.connect.data.remote.dto.ProfileModel

interface ProfileRepository {
    suspend fun getAllProfile():ProfileModel
}