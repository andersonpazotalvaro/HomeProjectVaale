package com.microservicio.home.supplier_invitation.adaptador

import com.microservicio.home.supplier_invitation.adaptador.repositorio.MapperSupplierInvitation
import com.microservicio.home.supplier_invitation.adaptador.repositorio.RepositorioSupplierInvitationJpa
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import com.microservicio.home.supplier_invitation.puerto.RepositorioSupplierInvitation
import org.springframework.stereotype.Repository

@Repository
open class RepositorioSupplierInvitationSql(
    private val mapperSupplierInvitation: MapperSupplierInvitation,
    private val repositorioSupplierInvitationJpa: RepositorioSupplierInvitationJpa
) : RepositorioSupplierInvitation  {

    override fun guardar(list: List<SupplierInvitation>): Boolean {
        var listaEntidad = this.mapperSupplierInvitation.convertirListaDominioAEntidad(list)
        this.repositorioSupplierInvitationJpa.saveAll(listaEntidad)
        return true
    }

    override fun existe(list: List<SupplierInvitation>): Boolean {
        TODO("Not yet implemented")
    }

}