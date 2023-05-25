package com.microservicio.home.supplier_invitation.modelo

import com.microservicio.home.SupplierInvitation.ValidadorParametro
import java.sql.Timestamp

data class SupplierInvitation(
    val supplier: Long,
    val commerceCellPhone: String,
    var entryDate: Timestamp?
    )
{
    constructor(supplierId: Long, commerceCellPhone: String) : this( supplierId, commerceCellPhone,Timestamp(System.currentTimeMillis()))

    init {
        ValidadorParametro.validarValorNulo(supplier,"El supplier no puede estar vacio")
        ValidadorParametro.validarValorVacio(commerceCellPhone, "El numero de celular no pueder ser vacio")
    }
}