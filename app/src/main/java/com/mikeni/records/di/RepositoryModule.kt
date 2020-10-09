package com.mikeni.records.di

import com.mikeni.records.data.local.CacheMapper
import com.mikeni.records.data.local.RecordDao
import com.mikeni.records.data.remote.NetworkMapper
import com.mikeni.records.data.remote.RecordService
import com.mikeni.records.data.repository.RecordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        recordDao: RecordDao,
        recordService: RecordService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): RecordRepository = RecordRepository(recordDao, recordService, cacheMapper, networkMapper)
}