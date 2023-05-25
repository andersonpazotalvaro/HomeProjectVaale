package com.microservicio.home.supplier_invitation.adaptador.consulta

import com.microservicio.home.supplier_invitation.adaptador.MapperSupplierInvitation
import com.microservicio.home.supplier_invitation.adaptador.repositorio.RepositorioSupplierInvitationJpa
import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaSupplierInvitation
import com.microservicio.home.supplier_invitation.puerto.DaoSupplierInvitation
import org.springframework.stereotype.Repository

@Repository
open class DaoSupplierInvitationSql(
    private val repositorioSupplierInvitationJpa: RepositorioSupplierInvitationJpa,
    private val mapperSupplierInvitation: MapperSupplierInvitation
):DaoSupplierInvitation
{


     override fun obtenerSupplierInvitation(): List<DtoRespuestaSupplierInvitation?> {
         this.repositorioSupplierInvitationJpa.findAll().let {
             return mapperSupplierInvitation.crearListaDtoRespuestaSupplierInvitation(it.toList()) }

    }


}