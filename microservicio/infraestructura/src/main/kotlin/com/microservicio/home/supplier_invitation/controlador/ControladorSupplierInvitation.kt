package com.microservicio.home.supplier_invitation.controlador

import com.microservicio.home.supplier_invitation.comando.manejador.ManejadorSupplierInvitation
import com.microservicio.home.supplier_invitation.consulta.ConsultaTodosSupplierInvitation
import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaConsultar
import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaGuardar
import org.apache.commons.io.FileUtils
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Path


@RestController
class ControladorSupplierInvitation (
    private val root: Path = Paths.get("uploads/"),
    private val manejadorSupplierInvitation: ManejadorSupplierInvitation,
    private val consultaTodosSupplierInvitation: ConsultaTodosSupplierInvitation
)
{

    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @PostMapping(consumes = [MediaType.MULTIPART_FORM_DATA_VALUE], value = ["/invitation/csv"])
    fun enviar(@RequestPart("file") file: MultipartFile): ResponseEntity<DtoRespuestaGuardar> {
        val fileToDelete = File(root.resolve(file.originalFilename).toString())
        FileUtils.cleanDirectory(root.toFile())

        try {
            Files.copy(file.inputStream, root.resolve(file.originalFilename))

            val fileTemporal = File(root.resolve(file.originalFilename).toString())

            val listDto = manejadorSupplierInvitation.guardarSupplierInvitation(fileTemporal)
            this.manejadorSupplierInvitation.deleteFile(root.resolve(file.originalFilename).toString())
            return ResponseEntity(DtoRespuestaGuardar(HttpStatus.OK.value(),"",listDto),HttpStatus.OK)
        } catch (e: Exception) {
            this.manejadorSupplierInvitation.deleteFile(root.resolve(file.originalFilename).toString())
            FileUtils.cleanDirectory(root.toFile())
            return ResponseEntity(DtoRespuestaGuardar(HttpStatus.NOT_FOUND.value(),e.message,null),HttpStatus.NOT_FOUND)
        }

    }
    @CrossOrigin(origins = ["*"], allowedHeaders = ["*"])
    @GetMapping(value = ["/invitation"])
    fun consultar(): ResponseEntity<DtoRespuestaConsultar>{
        try {
            return ResponseEntity(this.consultaTodosSupplierInvitation.consultarSupplierInvitation(HttpStatus.OK.value(),""),HttpStatus.OK)
        }catch (e: Exception){
            return ResponseEntity(this.consultaTodosSupplierInvitation.consultarSupplierInvitation(HttpStatus.NOT_FOUND.value(),e.message),HttpStatus.NOT_FOUND)
        }

    }




}
