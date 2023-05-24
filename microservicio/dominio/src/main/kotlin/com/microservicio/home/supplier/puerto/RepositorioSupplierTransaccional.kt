package com.microservicio.home.supplier.puerto

import com.microservicio.home.supplier.modelo.Supplier

interface RepositorioSupplierTransaccional {

    fun consultarPorId(id: Long) : Supplier
}