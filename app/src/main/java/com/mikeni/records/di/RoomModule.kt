package com.mikeni.records.di

import android.content.Context
import androidx.room.Room
import com.mikeni.records.data.local.RecordDatabase
import com.mikeni.records.data.local.RecordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRecordDb(@ApplicationContext context: Context): RecordDatabase =
        Room.databaseBuilder(
            context,
            RecordDatabase::class.java,
            RecordDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideRecordDAO(recordDatabase: RecordDatabase): RecordDao = recordDatabase.incidentsDao()
}