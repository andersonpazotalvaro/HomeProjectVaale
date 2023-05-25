package com.microservicio.home.supplier_invitation.entidad

import com.microservicio.home.supplier.entidad.EntidadSupplier
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "supplier_invitation")
class EntidadSupplierInvitation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 20)
    val id: Long? = 0,

    @ManyToOne(cascade = [])
    @JoinColumn(name = "supplier_id")
    val supplier: EntidadSupplier? = null,
    @Column(name="commerce_cell_phone", length = 256)
    val commerceCellPhone: String? = null,
    @Column(name="entry_date")
    val entryDate: Timestamp? = null

) {

    constructor(supplierId: EntidadSupplier?, commerceCellPhone: String?, entryDate: Timestamp?) : this(0, supplierId, commerceCellPhone, entryDate)

}