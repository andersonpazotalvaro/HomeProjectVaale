package com.microservicio.home.supplier_invitation.adaptador.repositorio

import com.microservicio.home.supplier_invitation.entidad.EntidadSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import org.springframework.stereotype.Component

@Component
class MapperSupplierInvitation {

    fun crearEntidad(supplierInvitation : SupplierInvitation): EntidadSupplierInvitation {
        return EntidadSupplierInvitation(supplierInvitation.supplierId,supplierInvitation.commerceCellPhone, supplierInvitation.entryDate  )
    }

    fun convertirListaDominioAEntidad(supplierInvitation: List<SupplierInvitation>): List<EntidadSupplierInvitation>{
        val listaEntidad = ArrayList<EntidadSupplierInvitation>()
        supplierInvitation.forEach { supplier ->
            listaEntidad.add(crearEntidad(supplier))
        }
        return listaEntidad
    }
}