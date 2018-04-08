package blogapp.bittupatel.`in`.kotlinblogapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.Category
import blogapp.bittupatel.`in`.kotlinblogapp.R
import blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder.CategoryViewHolder


class CategoryAdapter(var categories: MutableList<Category?>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        return CategoryViewHolder(v)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTitle.text = category?.title
        holder.category = category
    }

    override fun getItemCount(): Int {
        return categories.count()
    }
}

