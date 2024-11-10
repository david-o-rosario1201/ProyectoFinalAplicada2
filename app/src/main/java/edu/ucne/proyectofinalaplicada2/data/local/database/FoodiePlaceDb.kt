package edu.ucne.proyectofinalaplicada2.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.ucne.proyectofinalaplicada2.data.local.dao.CategoriaDao
import edu.ucne.proyectofinalaplicada2.data.local.dao.ReservacionesDao
import edu.ucne.proyectofinalaplicada2.data.local.dao.ProductoDao

import edu.ucne.proyectofinalaplicada2.data.local.dao.ReviewDao
import edu.ucne.proyectofinalaplicada2.data.local.dao.UsuarioDao
import edu.ucne.proyectofinalaplicada2.data.local.entities.ReservacionesEntity
import edu.ucne.proyectofinalaplicada2.data.local.dao.CarritoDao
import edu.ucne.proyectofinalaplicada2.data.local.dao.CarritoDetalleDao
import edu.ucne.proyectofinalaplicada2.data.local.entities.CategoriaEntity
import edu.ucne.proyectofinalaplicada2.data.local.entities.ReviewEntity
import edu.ucne.proyectofinalaplicada2.data.local.entities.UsuarioEntity
import edu.ucne.proyectofinalaplicada2.data.local.entities.CarritoEntity
import edu.ucne.proyectofinalaplicada2.data.local.entities.CarritoDetalleEntity
import edu.ucne.proyectofinalaplicada2.data.local.entities.ProductoEntity

@Database(
    entities = [
        ReviewEntity::class,
        UsuarioEntity::class,
        ReservacionesEntity::class,
        CategoriaEntity::class,
        CarritoEntity::class,
        ProductoEntity::class,
        CarritoDetalleEntity::class,

    ],
    version = 1,
    exportSchema = false
)

abstract class FoodiePlaceDb : RoomDatabase(){

    abstract val ProductoDao: ProductoDao
    abstract fun reservacionesDao(): ReservacionesDao
    abstract fun reviewDao(): ReviewDao
    abstract fun usuarioDao(): UsuarioDao
    abstract fun categoriaDao(): CategoriaDao
    abstract fun carritoDao(): CarritoDao
    abstract fun carritoDetalleDao(): CarritoDetalleDao

}