package blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import blogapp.bittupatel.`in`.kotlinblogapp.Category
import blogapp.bittupatel.`in`.kotlinblogapp.CategoryFeed
import blogapp.bittupatel.`in`.kotlinblogapp.R


class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var category: Category? = null
    var categoryTitle: TextView = itemView.findViewById<View>(R.id.categoryTitle) as TextView

    companion object {

        val CATEGORY_ID_KEY = "CATEGORY_ID"
        val CATEGORY_TITLE_KEY = "CATEGORY_TITLE"

    }

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, CategoryFeed::class.java)

            intent.putExtra(CATEGORY_ID_KEY, category?.id)
            intent.putExtra(CATEGORY_TITLE_KEY, category?.title)

            itemView.context.startActivity(intent)
        }
    }
}