package com.microservicio.home.supplier.adaptador

import com.microservicio.home.supplier.entidad.EntidadSupplier
import com.microservicio.home.supplier.modelo.Supplier
import org.springframework.stereotype.Component
import java.util.*

@Component
class MapperSupplier {

    fun crearEntidad(supplier : Supplier): EntidadSupplier {
        return EntidadSupplier(supplier.name,supplier.code,supplier.isActive,supplier.entryDate  )
    }

    fun crearDominio(entidadSupplier: EntidadSupplier): Supplier {
        return Supplier(entidadSupplier.name,entidadSupplier.code,entidadSupplier.isActive,entidadSupplier.entryDate )
    }

}