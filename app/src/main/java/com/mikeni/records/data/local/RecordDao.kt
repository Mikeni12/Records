package com.mikeni.records.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecordDao {
    @Query("SELECT * FROM records")
    suspend fun getAllRecords() : List<RecordCacheEntity>

    @Query("SELECT * FROM records WHERE id = :id")
    suspend fun getRecord(id: Int): RecordCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(record: List<RecordCacheEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: RecordCacheEntity)
}