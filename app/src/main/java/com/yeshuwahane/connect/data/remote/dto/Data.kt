package com.yeshuwahane.connect.data.remote.dto

import com.yeshuwahane.connect.data.local.entity.ProfileEntity

data class Data(
    val avatar: String?,
    val email: String?,
    val first_name: String?,
    val id: Int?,
    val last_name: String?
)

fun ProfileEntity.toData():Data{
    return Data(
        avatar = avatarImage,
        email = email,
        first_name = firstName,
        id = pId,
        last_name = lastName
    )
}


