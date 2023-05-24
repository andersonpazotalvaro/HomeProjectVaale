package com.microservicio.home.supplier

import java.sql.Timestamp

class DtoSupplier (
    val name: String,
    val code: String,
    val isActive: Boolean,
    val entryDate: Timestamp
)
{}