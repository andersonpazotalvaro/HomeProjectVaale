package com.microservicio.home.supplier_invitation.adaptador

import com.microservicio.home.supplier.adaptador.MapperSupplier
import com.microservicio.home.supplier.adaptador.consulta.DaoSupplier
import com.microservicio.home.supplier_invitation.entidad.EntidadSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import org.springframework.stereotype.Component

@Component
class MapperSupplierInvitation(
    private val mapperSupplier: MapperSupplier,
    private val daoSupplier: DaoSupplier
) {

    fun crearEntidad(supplierInvitation : SupplierInvitation): EntidadSupplierInvitation {
        return EntidadSupplierInvitation(
            this.daoSupplier.consultarPorId(supplierInvitation.supplierId),
            supplierInvitation.commerceCellPhone,
            supplierInvitation.entryDate  )
    }

    fun convertirListaDominioAEntidad(supplierInvitation: List<SupplierInvitation>): List<EntidadSupplierInvitation>{
        val listaEntidad = ArrayList<EntidadSupplierInvitation>()
        supplierInvitation.forEach { supplier ->
            listaEntidad.add(crearEntidad(supplier))
        }
        return listaEntidad
    }
}