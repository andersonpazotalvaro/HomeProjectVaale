package com.microservicio.home.supplier_invitation.adaptador.consulta

import com.microservicio.home.supplier_invitation.adaptador.MapperSupplierInvitation
import com.microservicio.home.supplier_invitation.adaptador.repositorio.RepositorioSupplierInvitationJpa
import com.microservicio.home.supplier_invitation.entidad.EntidadSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.DtoRespuestaSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.SupplierInvitation
import com.microservicio.home.supplier_invitation.puerto.DaoSupplierInvitation
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

@Repository
open class DaoSupplierInvitationSql(
    private val repositorioSupplierInvitationJpa: RepositorioSupplierInvitationJpa,
    private val mapperSupplierInvitation: MapperSupplierInvitation
):DaoSupplierInvitation
{


     override fun obtenerSupplierInvitation(): List<DtoRespuestaSupplierInvitation?> {
            var listaEntidad = this.repositorioSupplierInvitationJpa.findAll()?.let {
                return it.toList() }

    }


}