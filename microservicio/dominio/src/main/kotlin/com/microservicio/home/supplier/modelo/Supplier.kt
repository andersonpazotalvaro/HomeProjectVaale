package com.microservicio.home.supplier.modelo

import com.microservicio.home.SupplierInvitation.ValidadorParametro
import java.sql.Timestamp

class Supplier(
    val name: String?,
    val code: String?,
    val isActive: Boolean,
    val entryDate: Timestamp?
)
{

    constructor(name: String, code: String, isActive: Boolean) : this( name, code, isActive,Timestamp(System.currentTimeMillis()))

    init {
        ValidadorParametro.validarValorVacio(name,"El nombre no puede estar vacio")
        ValidadorParametro.validarValorVacio(code,"El codigo no puede estar vacio")
    }

}