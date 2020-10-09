package com.mikeni.records.data.remote

import com.mikeni.records.data.entities.Record
import com.mikeni.records.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper @Inject constructor() : EntityMapper<RecordNetworkEntity, Record> {
    override fun mapFromEntity(entity: RecordNetworkEntity): Record {
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
                recordId,
                recordTimestamp
            )
        }
    }

    override fun mapToEntity(domainModel: Record): RecordNetworkEntity {
        with(domainModel) {
            return RecordNetworkEntity(
                dataset,
                RecordNetworkEntity.Fields(
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
                RecordNetworkEntity.Geometry(
                    geometry.coordinates,
                    geometry.type
                ),
                id,
                timestamp
            )
        }
    }

    fun mapFromEntityList(entities: List<RecordNetworkEntity>): List<Record> =
        entities.map { mapFromEntity(it) }

}