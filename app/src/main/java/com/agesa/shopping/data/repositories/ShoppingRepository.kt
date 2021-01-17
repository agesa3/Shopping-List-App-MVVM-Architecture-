package com.agesa.shopping.data.repositories

import com.agesa.shopping.data.db.ShoppingDatabase
import com.agesa.shopping.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db:ShoppingDatabase
) {
    suspend fun upsert(item:ShoppingItem)=db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem)=db.getShoppingDao().delete(item)

    fun getAllShoppingItems()=db.getShoppingDao().getAllTheShoppingItems()

}