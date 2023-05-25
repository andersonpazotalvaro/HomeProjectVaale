package com.microservicio.home.supplier_invitation.modelo

import java.sql.Timestamp

class DtoRespuestaSupplierInvitation(
    val supplierId: Long,
    val supplierName: String,
    val commerceCellPhone: String
) {
}