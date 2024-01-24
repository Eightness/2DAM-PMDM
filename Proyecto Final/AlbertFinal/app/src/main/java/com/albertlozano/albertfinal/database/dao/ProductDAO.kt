/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.albertlozano.albertfinal.database.entities.Product

/**
 * ProductDAO Interface
 *
 */
@Dao
interface ProductDAO : GenericDAOInterface {
    @Query("SELECT * FROM product ORDER BY name")
    override fun getAllProducts(): LiveData<MutableList<Product>>

    @Query("SELECT * FROM product WHERE name = :name")
    override suspend fun getProductByName(name: String): Product

    @Query("SELECT count(*) FROM product WHERE name = :name")
    override suspend fun productExists(name: String): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addProduct(product: Product): Long

    @Update
    override suspend fun updateProduct(product: Product): Int

    @Delete
    override suspend fun deleteProduct(product: Product): Int

    @Query("DELETE FROM product")
    suspend fun deleteAllProducts()
}