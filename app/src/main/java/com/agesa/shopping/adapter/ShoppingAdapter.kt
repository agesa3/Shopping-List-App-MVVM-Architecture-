package com.agesa.shopping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agesa.shopping.R
import com.agesa.shopping.data.db.entities.ShoppingItem
import com.agesa.shopping.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*


class ShoppingAdapter(
    var item: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
       val curShoppingItem=item[position]

        holder.itemView.tvName.text=curShoppingItem.name
        holder.itemView.tvAmount.text="${curShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(curShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }
        holder.itemView.ivMinus.setOnClickListener {
            if (curShoppingItem.amount>0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }
    }
    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}