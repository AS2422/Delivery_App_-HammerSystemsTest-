package com.asafin24.hammersystems_test_safin.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.hammersystems_test_safin.R
import com.asafin24.hammersystems_test_safin.domain.models.Result
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductVH>() {

    private var products = emptyList<Result>()

    class ProductVH(item: View) : RecyclerView.ViewHolder(item)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH =
        ProductVH(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))

    override fun onBindViewHolder(holder: ProductVH, position: Int): Unit = holder.itemView.run {

        holder.itemView.tv_name_product.text = products[position].name
        holder.itemView.tv_description_product.text = products[position].gender
        holder.itemView.btn_price.text = products[position].status
        Glide.with(this).load(products[position].image).into(iv_product)

    }

    override fun getItemCount(): Int {
        return products.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Result>) {
        products = list
        notifyDataSetChanged()
    }

}





