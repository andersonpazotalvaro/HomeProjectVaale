package com.microservicio.home.supplier_invitation.puerto

import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaSupplierInvitation

interface DaoSupplierInvitation {

    open fun obtenerSupplierInvitation(): List<DtoRespuestaSupplierInvitation?>
}