/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.database.dao

import androidx.lifecycle.LiveData
import com.albertlozano.albertfinal.database.entities.Product

/**
 * GenericDAOInterface
 *
 */
interface GenericDAOInterface {
    fun getAllProducts(): LiveData<MutableList<Product>>

    suspend fun productExists(name: String): Int

    suspend fun getProductByName(name: String): Product

    suspend fun addProduct(product: Product): Long

    suspend fun updateProduct(product: Product): Int

    suspend fun deleteProduct(product: Product): Int
}