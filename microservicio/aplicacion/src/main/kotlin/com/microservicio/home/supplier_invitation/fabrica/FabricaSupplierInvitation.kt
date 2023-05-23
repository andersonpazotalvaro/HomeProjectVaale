package com.microservicio.home.supplier_invitation.fabrica

import com.microservicio.home.supplier_invitation.importarcsv.DtoSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import org.springframework.stereotype.Component

@Component
class FabricaSupplierInvitation {

    fun crear(dtoSupplierInvitation: DtoSupplierInvitation): SupplierInvitation{
        return SupplierInvitation(
            convertirStringAInt(dtoSupplierInvitation.supplierId),
            dtoSupplierInvitation.commerceCellPhone
            )
    }

    fun convertirDtoADominio(list: List<DtoSupplierInvitation>):List<SupplierInvitation>{
        var listadomain = ArrayList<SupplierInvitation>();
        list.forEach { dtoSupplier ->
            listadomain.add(this.crear(dtoSupplier))
        }
        return listadomain
    }

    fun convertirStringAInt(string:String):Int{
        var res = 0
        try {
            res = Integer.valueOf(string)
        }catch (e: Exception){

        }
        return res
    }
}