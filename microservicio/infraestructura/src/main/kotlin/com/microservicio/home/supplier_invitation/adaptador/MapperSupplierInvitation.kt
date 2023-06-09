package com.microservicio.home.supplier_invitation.adaptador

import com.microservicio.home.supplier.adaptador.consulta.DaoSupplier
import com.microservicio.home.supplier_invitation.entidad.EntidadSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import org.springframework.stereotype.Component

@Component
class MapperSupplierInvitation(
    private val daoSupplier: DaoSupplier
) {

    fun crearEntidad(supplierInvitation : SupplierInvitation): EntidadSupplierInvitation {
        return EntidadSupplierInvitation(
            this.daoSupplier.consultarPorId(supplierInvitation.supplier),
            supplierInvitation.commerceCellPhone,
            supplierInvitation.entryDate  )
    }

    fun convertirListaDominioAEntidad(supplierInvitation: List<SupplierInvitation>): List<EntidadSupplierInvitation>{
        //return supplierInvitation.stream().map(this::crearEntidad).toList()
        val listaEntidad = ArrayList<EntidadSupplierInvitation>()
        supplierInvitation.forEach { supplier ->
            listaEntidad.add(crearEntidad(supplier))
        }
        return listaEntidad
    }

    fun convertirRespuestaListaSupplierInvitation(entidad: EntidadSupplierInvitation) : DtoRespuestaSupplierInvitation {
        return DtoRespuestaSupplierInvitation(entidad.supplier!!.id!!,entidad.supplier!!.name!!,entidad.commerceCellPhone!!)
    }
    
    fun crearListaDtoRespuestaSupplierInvitation(listEntidad: List<EntidadSupplierInvitation>) : List<DtoRespuestaSupplierInvitation>{
       //return listEntidad.stream().map(this::convertirRespuestaListaSupplierInvitation).toList()
        val listaDto = ArrayList<DtoRespuestaSupplierInvitation>()
        listEntidad.forEach { dtoRespuesta ->
            listaDto.add(convertirRespuestaListaSupplierInvitation(dtoRespuesta))
        }
        return listaDto
    }
}