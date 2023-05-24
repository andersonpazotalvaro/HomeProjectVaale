package com.microservicio.home.supplier.adaptador.consulta

import com.microservicio.home.supplier.adaptador.MapperSupplier
import com.microservicio.home.supplier.adaptador.repositorio.RepositorioSupplierJpa
import com.microservicio.home.supplier.entidad.EntidadSupplier
import com.microservicio.home.supplier.modelo.Supplier
import org.springframework.stereotype.Repository
import java.util.*

@Repository
open class DaoSupplier (
    private val repositorioSupplierJpa: RepositorioSupplierJpa
)
{
     fun consultarPorId(id: Long): EntidadSupplier {
        val entidadSupplier = this.repositorioSupplierJpa.consultarPorId(id)//.orElseThrow { NoSuchElementException("El supplier no existe") }
         if (entidadSupplier != null){
             //val entidad: EntidadSupplier = entidadSupplier.get()
             return entidadSupplier
         }else{
             return EntidadSupplier(100,"NA", "NA", false, null)
         }
         //return entidadSupplier
    }
}