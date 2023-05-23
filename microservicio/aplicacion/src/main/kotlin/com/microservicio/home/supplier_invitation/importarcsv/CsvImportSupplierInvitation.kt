package com.microservicio.home.supplier_invitation.importarcsv

import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.charset.StandardCharsets

@Component
class CsvImportSupplierInvitation {

    fun importarCSV (file: File):List<DtoSupplierInvitation>{

        try {
            if (!file.exists()){
                throw java.lang.RuntimeException("Ruta o archivo inexistente")
            }

            val br = BufferedReader(FileReader(file, StandardCharsets.ISO_8859_1))
        }
    }

}