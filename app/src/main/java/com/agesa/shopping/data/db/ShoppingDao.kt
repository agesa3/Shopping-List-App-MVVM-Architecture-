package com.agesa.shopping.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.agesa.shopping.data.db.entities.ShoppingItem
@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)
    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllTheShoppingItems(): LiveData<List<ShoppingItem>>
}