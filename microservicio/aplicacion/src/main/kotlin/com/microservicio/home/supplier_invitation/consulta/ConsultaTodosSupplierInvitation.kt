package com.microservicio.home.supplier_invitation.consulta

import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaApi
import com.microservicio.home.supplier_invitation.modelo.Dto.DtoRespuestaConsultar
import com.microservicio.home.supplier_invitation.puerto.DaoSupplierInvitation
import org.springframework.stereotype.Component

@Component
class ConsultaTodosSupplierInvitation (
private val daoSupplierInvitation: DaoSupplierInvitation
        )
{
        fun consultarSupplierInvitation(int: Int, message: String?): DtoRespuestaConsultar {
             return DtoRespuestaConsultar(DtoRespuestaApi(int,message),this.daoSupplierInvitation.obtenerSupplierInvitation())
        }
}