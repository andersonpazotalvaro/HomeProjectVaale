package com.microservicio.home.supplier_invitation.puerto

import com.microservicio.home.supplier_invitation.modelo.DtoRespuestaSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation

interface DaoSupplierInvitation {

    open fun obtenerSupplierInvitation(): List<DtoRespuestaSupplierInvitation?>
}