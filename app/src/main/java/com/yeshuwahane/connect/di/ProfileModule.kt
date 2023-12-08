package com.yeshuwahane.connect.di

import android.content.Context
import androidx.room.Room
import com.yeshuwahane.connect.data.local.ProfileDao
import com.yeshuwahane.connect.data.local.ProfileDatabase
import com.yeshuwahane.connect.data.remote.ProfileApi
import com.yeshuwahane.connect.data.remote.repository.ProfileRepositoryImpl
import com.yeshuwahane.connect.data.remote.RetrofitInstance
import com.yeshuwahane.connect.domain.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ProfileModule {

    @Provides
    @Singleton
    fun provideProfileApi():ProfileApi{
        return RetrofitInstance.getRetrofitInstance().create(ProfileApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(repositoryImpl: ProfileRepositoryImpl):ProfileRepository{
        return repositoryImpl
    }

    @Provides
    fun provideLocalProfileDao(profileDatabase: ProfileDatabase):ProfileDao{
        return profileDatabase.profileDao()
    }

    @Provides
    @Singleton
    fun provideLocalPlantDatabase(@ApplicationContext appContext: Context):ProfileDatabase{
        return Room.databaseBuilder(
            appContext,ProfileDatabase::class.java,
            "plant_database"
        ).fallbackToDestructiveMigration()
            .build()

    }
}