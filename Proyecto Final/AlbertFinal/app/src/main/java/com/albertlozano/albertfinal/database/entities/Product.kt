/**
 * @author Albert Lozano Blasco
 * @version 2.1
 */

package com.albertlozano.albertfinal.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Product Data Class
 *
 * @property id
 * @property name
 * @property supermarket
 * @property price
 */
@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String = "",
    var supermarket: String = "",
    var price: Double = 0.0,
)
