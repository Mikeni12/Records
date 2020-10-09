package com.mikeni.records.data.local

import androidx.room.*

@Entity(tableName = "records")
class RecordCacheEntity(
    @ColumnInfo(name = "dataset_id")
    val datasetId: String,
    @Embedded val fields: Fields,
    @Embedded val geometry: Geometry,
    @PrimaryKey val id: String,
    @ColumnInfo(name = "record_timestamp")
    val recordTimestamp: String
) {

    data class Fields(
        val agencia: String,
        @ColumnInfo(name = "alcaldia_hechos")
        val alcaldiaHechos: String,
        @ColumnInfo(name = "ao_hechos")
        val aoHechos: String,
        @ColumnInfo(name = "ao_inicio")
        val aoInicio: String,
        @ColumnInfo(name = "calle_hechos")
        val calleHechos: String,
        @ColumnInfo(name = "calle_hechos2")
        val calleHechos2: String,
        @ColumnInfo(name = "categoria_delito")
        val categoriaDelito: String,
        @ColumnInfo(name = "colonia_hechos")
        val coloniaHechos: String,
        val delito: String,
        @ColumnInfo(name = "fecha_hechos")
        val fechaHechos: String,
        @ColumnInfo(name = "fecha_inicio")
        val fechaInicio: String,
        val fiscalia: String,
        val geopoint: List<Double>,
        val latitud: String,
        val longitud: String,
        @ColumnInfo(name = "mes_hechos")
        val mesHechos: String,
        @ColumnInfo(name = "mes_inicio")
        val mesInicio: String,
        @ColumnInfo(name = "unidad_investigacion")
        val unidadInvestigacion: String
    )

    data class Geometry(
        val coordinates: List<Double>,
        val type: String
    )
}