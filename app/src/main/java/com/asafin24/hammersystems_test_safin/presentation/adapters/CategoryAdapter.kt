package com.asafin24.hammersystems_test_safin.presentation.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asafin24.hammersystems_test_safin.R
import com.asafin24.hammersystems_test_safin.databinding.CategoryItemBinding
import com.asafin24.hammersystems_test_safin.domain.models.CategoryModel

class CategoryAdapter(val listener: Listener) : RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {

    var categoryList = mutableListOf(
        CategoryModel("Пицца", true),
        CategoryModel("Комбо"),
        CategoryModel("Десерты"),
        CategoryModel("Напитки")
    )

    class CategoryVH(item: View) : RecyclerView.ViewHolder(item) {

        val binding = CategoryItemBinding.bind(item)

        fun bind(category: CategoryModel, listener: Listener) {
            binding.tvCategoryName.text = category.categoryName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryVH(view)

    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {

        holder.bind(categoryList[position], listener)

        val category = categoryList[position]

        if (category.isSelected) listener.onClickCategory(holder.itemView)
        else listener.unClickCategory(holder.itemView)

        holder.itemView.setOnClickListener {
            for (i in 0 until categoryList.size) {
                categoryList[i].isSelected = false
            }
            category.isSelected = true
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    interface Listener {
        fun onClickCategory(category: View)
        fun unClickCategory(category: View)
    }

}