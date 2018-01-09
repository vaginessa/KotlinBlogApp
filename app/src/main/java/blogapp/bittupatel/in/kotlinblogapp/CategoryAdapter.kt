package blogapp.bittupatel.`in`.kotlinblogapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class CategoryAdapter(val categoryFeed: CategoryFeed) : RecyclerView.Adapter<CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_row, parent, false)
        return CategoryHolder(v)
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = categoryFeed.categories[position]
        holder.categoryTitle.text = category.title
        holder.imageView_cat.alpha = 0.3f
        when (category.title) {
            "Blogs" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.blog)
            }
            "Cyber Attack" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.cyber_attacks)
            }
            "Cyber News" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.cyber_news)
            }
            "Cyber Security" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.cyber_security)
            }
            "Did You Know??" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.did_you_know)
            }
            "Network Security" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.network_security)
            }
            "New Release" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.new_release)
            }
            "Research" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.research)
            }
            "Tech" -> {
                holder.imageView_cat.setBackgroundResource(R.drawable.tech)
            }
        }

        holder.category = category
    }

    override fun getItemCount(): Int {
        return categoryFeed.categories.count()
    }
}

class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var category: Category? = null
    var imageView_cat: ImageView = itemView.findViewById<View>(R.id.imageView_cat) as ImageView
    var categoryTitle: TextView = itemView.findViewById<View>(R.id.categoryTitle) as TextView

    companion object {

        val CATEGORY_ID_KEY = "CATEGORY_ID"
        val CATEGORY_TITLE_KEY = "CATEGORY_TITLE"

    }

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, CategoryDetail::class.java)

            intent.putExtra(CATEGORY_ID_KEY, category?.id)
            intent.putExtra(CATEGORY_TITLE_KEY, category?.title)

            itemView.context.startActivity(intent)
        }
    }
}