/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.albertlozano.albertfinal.database.dao.ProductDAO
import com.albertlozano.albertfinal.database.entities.Product

/**
 * ProductDatabase Abstract Class
 *
 */
@Database(entities = arrayOf(Product::class), version = 1)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun productDAO(): ProductDAO

    companion object {
        private var instance: ProductDatabase? = null

        fun getInstance(context: Context): ProductDatabase {
            return instance ?: Room.databaseBuilder(context, ProductDatabase::class.java, "product-db")
                .build()
                .also { instance = it }
        }
    }
}