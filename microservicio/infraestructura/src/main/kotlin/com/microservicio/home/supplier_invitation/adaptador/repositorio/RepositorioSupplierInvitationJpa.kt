package com.microservicio.home.supplier_invitation.adaptador.repositorio

import com.microservicio.home.supplier_invitation.entidad.EntidadSupplierInvitation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RepositorioSupplierInvitationJpa: JpaRepository<EntidadSupplierInvitation, Long> {
}