package com.yeshuwahane.connect.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yeshuwahane.connect.data.local.entity.ProfileEntity

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile_entity")
    suspend fun getAllProfile():List<ProfileEntity
            >

    @Insert
    suspend fun addProfile(vararg profileEntity: ProfileEntity
    )

    @Delete
    suspend fun removeProfile(profileEntity: ProfileEntity
    )

    @Update
    suspend fun addForActivity(profileEntity: ProfileEntity
    )
}