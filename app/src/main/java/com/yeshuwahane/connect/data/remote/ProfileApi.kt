package com.yeshuwahane.connect.data.remote

import com.yeshuwahane.connect.data.remote.dto.ProfileModel
import retrofit2.http.GET

interface ProfileApi {

    @GET("api/users?page=2")
    suspend fun getProfiles(): ProfileModel
}