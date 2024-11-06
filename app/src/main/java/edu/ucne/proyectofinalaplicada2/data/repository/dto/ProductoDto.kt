package edu.ucne.proyectofinalaplicada2.data.repository.dto

import java.math.BigDecimal

data class ProductoDto (
    val productoId: Int,
    val nombre: String,
    val categoriaId: Int,
    val descripcion: String,
    val precio: BigDecimal,
    val disponibilidad: Boolean,
    val imagen: String
)