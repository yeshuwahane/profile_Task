package com.yeshuwahane.connect.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yeshuwahane.connect.data.local.entity.ProfileEntity

@Database(entities = [ProfileEntity::class], version = 2, exportSchema = false)
abstract class ProfileDatabase: RoomDatabase() {

    abstract fun profileDao():ProfileDao
}