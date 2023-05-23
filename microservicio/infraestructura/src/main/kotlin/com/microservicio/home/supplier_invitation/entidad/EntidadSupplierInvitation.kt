package com.microservicio.home.supplier_invitation.entidad

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "supplier_invitation")
class EntidadSupplierInvitation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Long? = 0,
    @Column(name="supplier_id")
    var supplierId: Int? = 0,
    @Column(name="commerce_cell_phone")
    var commerceCellPhone: String? = "",
    @Column(name="entry_date")
    var entryDate: Timestamp? = null

) {

    constructor(supplierId: Int?, commerceCellPhone: String?, entryDate: Timestamp?) : this(0, supplierId, commerceCellPhone, entryDate)

}