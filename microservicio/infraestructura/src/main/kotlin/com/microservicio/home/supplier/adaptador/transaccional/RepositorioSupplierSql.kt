package com.microservicio.home.supplier.adaptador.transaccional

import com.microservicio.home.supplier.adaptador.MapperSupplier
import com.microservicio.home.supplier.adaptador.repositorio.RepositorioSupplierJpa
import com.microservicio.home.supplier.entidad.EntidadSupplier
import com.microservicio.home.supplier.modelo.Supplier
import com.microservicio.home.supplier.puerto.RepositorioSupplier
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class RepositorioSupplierSql(
    private val mapperSupplier: MapperSupplier,
    private val repositorioSupplierJpa: RepositorioSupplierJpa
) : RepositorioSupplier
{
    override fun guardar(supplier: Supplier): Boolean {
        val entidad = this.mapperSupplier.crearEntidad(supplier)
        this.repositorioSupplierJpa.save(entidad)
        return true
    }

    override fun eliminar(id: Long): Boolean {
        this.repositorioSupplierJpa.deleteById(id)
        return true
    }

}