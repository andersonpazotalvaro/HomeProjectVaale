package com.microservicio.home.supplier_invitation.modelo.Dto

import java.sql.Timestamp

class DtoRespuestaSupplierInvitation(
    val supplierId: Long,
    val supplierName: String,
    val commerceCellPhone: String
) {
}