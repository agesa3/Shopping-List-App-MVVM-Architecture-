package com.agesa.shopping.ui.shoppinglist

import com.agesa.shopping.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item:ShoppingItem)
}