package com.microservicio.home.supplier_invitation.modelo

import com.microservicio.home.supplier.modelo.Supplier
import java.sql.Timestamp

data class SupplierInvitation(
    val supplierId: Long,
    val commerceCellPhone: String,
    var entryDate: Timestamp?
    )
{
    constructor(supplierId: Long, commerceCellPhone: String) : this( supplierId, commerceCellPhone,Timestamp(System.currentTimeMillis()))

    init {

    }
}