package com.microservicio.home.supplier.entidad

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "supplier")
class EntidadSupplier (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length = 20)
    val id: Long? = 0,
    @Column(name="name", length = 256)
    val name: String? = "",
    @Column(name="code", length = 45)
    val code: String? = null,
    @Column(name="is_active")
    val isActive: Boolean = true,
    @Column(name="entry_date")
    val entryDate: Timestamp? = null
)
{

    constructor(name: String?, code: String?, isActive: Boolean, entryDate: Timestamp?) : this(0, name, code, isActive, entryDate)
}