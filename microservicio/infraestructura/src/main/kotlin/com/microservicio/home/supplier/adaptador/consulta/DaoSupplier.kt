package com.microservicio.home.supplier.adaptador.consulta

import com.microservicio.home.supplier.adaptador.repositorio.RepositorioSupplierJpa
import com.microservicio.home.supplier.entidad.EntidadSupplier
import error.ExcepcionSupplierInexistente
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class DaoSupplier (
    private val repositorioSupplierJpa: RepositorioSupplierJpa
)
{
    open fun consultarPorId(id: Long): EntidadSupplier? {
        try {
            var entidadSupplier: EntidadSupplier? = this.repositorioSupplierJpa.getById(id)
            return entidadSupplier
        }catch (e: Exception){
            throw ExcepcionSupplierInexistente("El supplier con id : $id no existe")
        }

    }
}