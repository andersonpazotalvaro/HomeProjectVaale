package com.microservicio.home.supplier_invitation.puerto

import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation

interface RepositorioSupplierInvitation {

    fun guardar(list:List<SupplierInvitation>): Boolean
    fun existe(list:List<SupplierInvitation>): Boolean

}