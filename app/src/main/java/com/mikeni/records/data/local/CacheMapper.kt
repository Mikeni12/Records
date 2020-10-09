package com.mikeni.records.data.local

import com.mikeni.records.data.entities.Record
import com.mikeni.records.utils.EntityMapper
import javax.inject.Inject

class CacheMapper @Inject constructor(): EntityMapper<RecordCacheEntity, Record> {
    override fun mapFromEntity(entity: RecordCacheEntity): Record {
        with(entity) {
            return Record(
                datasetId,
                Record.Fields(
                    fields.agencia,
                    fields.alcaldiaHechos,
                    fields.aoHechos,
                    fields.aoInicio,
                    fields.calleHechos,
                    fields.calleHechos2,
                    fields.categoriaDelito,
                    fields.coloniaHechos,
                    fields.delito,
                    fields.fechaHechos,
                    fields.fechaInicio,
                    fields.fiscalia,
                    fields.geopoint,
                    fields.latitud,
                    fields.longitud,
                    fields.mesHechos,
                    fields.mesInicio,
                    fields.unidadInvestigacion
                ),
                Record.Geometry(geometry.coordinates, geometry.type),
                id,
                recordTimestamp
            )
        }
    }

    override fun mapToEntity(domainModel: Record): RecordCacheEntity {
        with(domainModel) {
            return RecordCacheEntity(
                dataset,
                RecordCacheEntity.Fields(
                    fields.agencia,
                    fields.alcaldiaHechos,
                    fields.aoHechos,
                    fields.aoInicio,
                    fields.calleHechos,
                    fields.calleHechos2,
                    fields.categoriaDelito,
                    fields.coloniaHechos,
                    fields.delito,
                    fields.fechaHechos,
                    fields.fechaInicio,
                    fields.fiscalia,
                    fields.geopoint,
                    fields.latitud,
                    fields.longitud,
                    fields.mesHechos,
                    fields.mesInicio,
                    fields.unidadInvestigacion
                ),
                RecordCacheEntity.Geometry(
                    geometry.coordinates,
                    geometry.type
                ),
                id,
                timestamp
            )
        }
    }

    fun mapFromEntityList(entities: List<RecordCacheEntity>): List<Record> =
        entities.map { mapFromEntity(it) }

}