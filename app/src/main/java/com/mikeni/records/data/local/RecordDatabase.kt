package com.mikeni.records.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mikeni.records.utils.Converters

@Database(entities = [RecordCacheEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RecordDatabase : RoomDatabase() {

    abstract fun incidentsDao(): RecordDao

    companion object {

        const val DATABASE_NAME = "incidents.db"

        /*@Volatile
        private var instance: RecordDatabase? = null

        fun getDatabase(context: Context): RecordDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, RecordDatabase::class.java, "incidents.db")
                .fallbackToDestructiveMigration()
                .build()
         */
    }

}