package com.mikeni.records.data.entities

data class Record(
    val dataset: String,
    val fields: Fields,
    val geometry: Geometry,
    val id: String,
    val timestamp: String
) {

    data class Fields(
        val agencia: String,
        val alcaldiaHechos: String,
        val aoHechos: String,
        val aoInicio: String,
        val calleHechos: String,
        val calleHechos2: String,
        val categoriaDelito: String,
        val coloniaHechos: String,
        val delito: String,
        val fechaHechos: String,
        val fechaInicio: String,
        val fiscalia: String,
        val geopoint: List<Double>,
        val latitud: String,
        val longitud: String,
        val mesHechos: String,
        val mesInicio: String,
        val unidadInvestigacion: String
    )

    data class Geometry(
        val coordinates: List<Double>,
        val type: String
    )
}