package com.microservicio.home.supplier.adaptador.repositorio

import com.microservicio.home.supplier.entidad.EntidadSupplier
import org.springframework.data.jpa.repository.JpaRepository

interface RepositorioSupplierJpa: JpaRepository<EntidadSupplier, Long> {
}