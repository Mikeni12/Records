package com.mikeni.records.data.repository

import com.mikeni.records.data.entities.Record
import com.mikeni.records.data.local.CacheMapper
import com.mikeni.records.data.local.RecordDao
import com.mikeni.records.data.remote.NetworkMapper
import com.mikeni.records.data.remote.RecordService
import com.mikeni.records.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RecordRepository(
    private val recordDao: RecordDao,
    private val recordService: RecordService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getRecords(): Flow<DataState<List<Record>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val response = recordService.getRecords()
            val records = networkMapper.mapFromEntityList(response.records)
            recordDao.insertAll(records.map { cacheMapper.mapToEntity(it) })
            val cachedRecords = recordDao.getAllRecords()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedRecords)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}