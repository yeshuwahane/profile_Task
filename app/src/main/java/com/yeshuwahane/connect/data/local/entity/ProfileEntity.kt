package com.yeshuwahane.connect.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yeshuwahane.connect.data.remote.dto.Data

@Entity(tableName = "profile_entity")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = false) val pId: Int?,
    @ColumnInfo(name = "email")val email: String? = "",
    @ColumnInfo(name = "firstName")val firstName: String? = "",
    @ColumnInfo(name = "lastName")val lastName: String? = "",
    @ColumnInfo(name = "avatarImage")val avatarImage:String? = "",
    @ColumnInfo(name = "id")val id:Int? = 0

)


fun Data.toEntity(): ProfileEntity {
    return ProfileEntity(
        pId = id,
        email = this.email,
        firstName = this.first_name,
        lastName = this.last_name,
        avatarImage = this.avatar,
    )
}