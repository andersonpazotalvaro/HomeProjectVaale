package com.microservicio.home.supplier_invitation.comando.importarcsv

import com.microservicio.home.supplier_invitation.DtoSupplierInvitation
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.nio.charset.StandardCharsets
import java.nio.file.Path
import java.nio.file.Paths

@Component
class CsvImportSupplierInvitation(
    private val root: Path = Paths.get("uploads/")
) {

    private fun dtoList(supplierId: String, commerceCellPhone: String): DtoSupplierInvitation {
        return DtoSupplierInvitation(supplierId,commerceCellPhone)
    }

    fun importarCSV (file: File):List<DtoSupplierInvitation>{
        var dtoList = ArrayList<DtoSupplierInvitation>()

        try {
            if (!file.exists()){
                throw java.lang.RuntimeException("Ruta o archivo inexistente")
            }

            val br = BufferedReader(FileReader(file, StandardCharsets.ISO_8859_1))

            var nextRecor: String? = br.readLine()

            while (nextRecor != null) {

                val nextRecord: Array<String> = nextRecor.split(";").toTypedArray()

                val supplierId: String = nextRecord[0]
                val commerceCellPhone: String = nextRecord[1]

                dtoList.add( dtoList(
                    supplierId,
                    commerceCellPhone))

                nextRecor = br.readLine()
            }
            br.close()
        }catch (e: Exception){

        }
        return dtoList
    }

    fun deleteFile(filename: String) {
        val fileToDelete = File(root.resolve(filename).toString())
        if (fileToDelete.exists()) {
            fileToDelete.delete()
        }
    }
}