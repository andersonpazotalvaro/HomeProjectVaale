package com.microservicio.home.supplier_invitation.modelo

import java.sql.Timestamp

data class SupplierInvitation(
    val supplierId: Int?,
    val commerceCellPhone: String?,
    var entryDate: Timestamp?
    )
{
    constructor(supplierId: Int?, commerceCellPhone: String?) : this( supplierId, commerceCellPhone,Timestamp(System.currentTimeMillis()))

    init {

    }
}