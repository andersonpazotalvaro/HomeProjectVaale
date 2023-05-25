package com.microservicio.home.supplier_invitation.comando.manejador

import com.microservicio.home.supplier_invitation.comando.fabrica.FabricaSupplierInvitation
import com.microservicio.home.supplier_invitation.comando.importarcsv.CsvImportSupplierInvitation
import com.microservicio.home.supplier_invitation.DtoSupplierInvitation
import com.microservicio.home.supplier_invitation.servicio.GuardarSupplierInvitation
import org.springframework.stereotype.Component
import java.io.File

@Component
class ManejadorSupplierInvitation(
    private val guardarSupplierInvitation: GuardarSupplierInvitation,
    private val fabricaSupplierInvitation: FabricaSupplierInvitation,
    private val csvImportSupplierInvitation: CsvImportSupplierInvitation,
    private val GUARDO: String = "guardo exitosamente : "
)
{
    fun guardarSupplierInvitation(file: File): List<DtoSupplierInvitation>{
        var listDto = this.csvImportSupplierInvitation.importarCSV(file)
        var listDomain = this.fabricaSupplierInvitation.convertirDtoADominio(listDto)
        this.guardarSupplierInvitation.ejecutar(listDomain)
        return listDto
    }

    fun deleteFile(filename: String) {
        this.csvImportSupplierInvitation.deleteFile(filename)
    }
}