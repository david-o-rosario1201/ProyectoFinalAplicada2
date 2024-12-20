package edu.ucne.proyectofinalaplicada2.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "Review")
data class ReviewEntity (
    @PrimaryKey
    val resenaId: Int? = 0,
    val usuarioId: Int,
    val comentario: String,
    val fechaResena: String,
    val calificacion: Int
)