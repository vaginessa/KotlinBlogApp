package blogapp.bittupatel.`in`.kotlinblogapp.adapters

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.Post
import blogapp.bittupatel.`in`.kotlinblogapp.R
import blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder.HomeViewHolder
import com.squareup.picasso.Picasso


class CategoryFeedAdapter(var posts: MutableList<Post?>) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return HomeViewHolder(v)
    }

    override fun onBindViewHolder(holder: HomeViewHolder?, position: Int) {
        val post = posts[position]
        holder?.postTitle?.text = Html.fromHtml(post?.title_plain)
        holder?.authorName?.text = post?.date + "  •  " + post?.author

        Picasso.with(holder?.itemView?.context).load(post?.thumbnail_images).into(holder?.thumbnailImageView)

        holder?.post = post

    }

    override fun getItemCount(): Int {
        return posts.count()
    }
}

