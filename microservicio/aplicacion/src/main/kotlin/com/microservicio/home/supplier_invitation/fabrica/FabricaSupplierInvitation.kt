package com.microservicio.home.supplier_invitation.fabrica

import com.microservicio.home.supplier_invitation.DtoSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import org.springframework.stereotype.Component

@Component
class FabricaSupplierInvitation(
)
{

    fun crear(dtoSupplierInvitation: DtoSupplierInvitation): SupplierInvitation{
        return SupplierInvitation(
            convertirStringALong(dtoSupplierInvitation.supplierId),
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

    fun convertirStringALong(string:String):Long{
        var res: Long = 0
            try {
            res = string.toLong()
        }catch (e: Exception){

        }
        return res
    }
}