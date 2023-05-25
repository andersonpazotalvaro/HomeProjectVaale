package com.microservicio.home.supplier.adaptador.repositorio

import com.microservicio.home.supplier.DtoSupplier
import com.microservicio.home.supplier.entidad.EntidadSupplier
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface RepositorioSupplierJpa: JpaRepository<EntidadSupplier, Long> {
}