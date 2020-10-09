package com.mikeni.records.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface RecordService {
    @GET("search/")
    suspend fun getRecords(
        @Query("dataset") dataset: String = "carpetas-de-investigacion-pgj-de-la-ciudad-de-mexico",
        @Query("facet") facet: String = "delito"
    ): ApiResponse
}