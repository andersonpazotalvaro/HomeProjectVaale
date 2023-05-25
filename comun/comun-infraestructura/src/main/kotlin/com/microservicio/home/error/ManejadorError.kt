package com.microservicio.home.error

import com.microservicio.home.excepcion.ExcepcionArgumentoInvalido
import com.microservicio.home.excepcion.ExcepcionInexistente
import error.ExcepcionErrorAlGuardar
import error.ExcepcionSupplierInexistente
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.concurrent.ConcurrentHashMap

@ControllerAdvice
class ManejadorError {

    private val OCURRIO_UN_ERROR_INESPERADO = "Ocurrio un error inesperado"
    private val CODIGOS_RESPUESTA = ConcurrentHashMap<String, Int>()

    init {
        // Cargar los codigos de respuesta http de las excepciones manejadas en la api

        CODIGOS_RESPUESTA[ExcepcionInexistente::class.simpleName!!] = HttpStatus.BAD_REQUEST.value()
        CODIGOS_RESPUESTA[ExcepcionArgumentoInvalido::class.simpleName!!] = HttpStatus.BAD_REQUEST.value()
        CODIGOS_RESPUESTA[ExcepcionSupplierInexistente::class.simpleName!!] = HttpStatus.NOT_FOUND.value()
        CODIGOS_RESPUESTA[ExcepcionErrorAlGuardar::class.simpleName!!] = HttpStatus.BAD_REQUEST.value()
    }

    @ExceptionHandler(Exception::class)
    fun manejarExcepcion(exception: Exception): ResponseEntity<Error> {
        val excepcionNombre = exception.javaClass.simpleName
        val excepcionMensaje = exception.message
        val codigoRespuesta = CODIGOS_RESPUESTA[excepcionNombre]

        if (codigoRespuesta != null) {
            val error = Error(excepcionNombre, excepcionMensaje)
            return ResponseEntity(error, HttpStatus.valueOf(codigoRespuesta))
        }

        val error = Error(excepcionNombre, OCURRIO_UN_ERROR_INESPERADO)
        return ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR)
    }
}