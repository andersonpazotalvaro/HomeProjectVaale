package com.microservicio.home.supplier.puerto

import com.microservicio.home.supplier.modelo.Supplier


interface RepositorioSupplier {

    fun guardar(supplier: Supplier): Boolean
    fun eliminar(id : Long): Boolean



}