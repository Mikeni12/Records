package com.mikeni.records.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RecordNetworkEntity(
    @Json(name = "datasetid")
    val datasetId: String,
    @Json(name = "fields")
    val fields: Fields,
    @Json(name = "geometry")
    val geometry: Geometry,
    @Json(name = "recordid")
    val recordId: String,
    @Json(name = "record_timestamp")
    val recordTimestamp: String
) {
    @JsonClass(generateAdapter = true)
    data class Fields(
        @Json(name = "agencia")
        val agencia: String,
        @Json(name = "alcaldia_hechos")
        val alcaldiaHechos: String,
        @Json(name = "ao_hechos")
        val aoHechos: String,
        @Json(name = "ao_inicio")
        val aoInicio: String,
        @Json(name = "calle_hechos")
        val calleHechos: String,
        @Json(name = "calle_hechos2")
        val calleHechos2: String,
        @Json(name = "categoria_delito")
        val categoriaDelito: String,
        @Json(name = "colonia_hechos")
        val coloniaHechos: String,
        @Json(name = "delito")
        val delito: String,
        @Json(name = "fecha_hechos")
        val fechaHechos: String,
        @Json(name = "fecha_inicio")
        val fechaInicio: String,
        @Json(name = "fiscalia")
        val fiscalia: String,
        @Json(name = "geopoint")
        val geopoint: List<Double>,
        @Json(name = "latitud")
        val latitud: String,
        @Json(name = "longitud")
        val longitud: String,
        @Json(name = "mes_hechos")
        val mesHechos: String,
        @Json(name = "mes_inicio")
        val mesInicio: String,
        @Json(name = "unidad_investigacion")
        val unidadInvestigacion: String
    )

    @JsonClass(generateAdapter = true)
    data class Geometry(
        @Json(name = "coordinates")
        val coordinates: List<Double>,
        @Json(name = "type")
        val type: String
    )
}