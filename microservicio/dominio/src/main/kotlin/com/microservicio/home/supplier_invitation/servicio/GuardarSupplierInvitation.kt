package com.microservicio.home.supplier_invitation.servicio

import com.microservicio.home.supplier.puerto.RepositorioSupplier
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import com.microservicio.home.supplier_invitation.puerto.RepositorioSupplierInvitation
import org.springframework.stereotype.Service

@Service
class GuardarSupplierInvitation(
    private val repositorioSupplierInvitation: RepositorioSupplierInvitation,
    private val GUARDO: String = "guardo exitosamente : "
) {

    fun ejecutar(list: List<SupplierInvitation>): String{
        this.repositorioSupplierInvitation.guardar(list)
        return GUARDO
    }


}