package com.microservicio.home.SupplierInvitation

import com.microservicio.home.excepcion.ExcepcionArgumentoInvalido

object ValidadorParametro {

    fun validarValorNulo(valor: Any?, mensaje: String) {
        if (valor == null) {
            throw ExcepcionArgumentoInvalido(mensaje)
        }
    }
    fun validarValorVacio(valor: String?, mensaje: String) {
        if (valor == null || valor.isEmpty()) {
            throw ExcepcionArgumentoInvalido(mensaje)
        }
    }


}