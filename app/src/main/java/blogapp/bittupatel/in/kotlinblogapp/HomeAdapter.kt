package blogapp.bittupatel.`in`.kotlinblogapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class HomeAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return CustomHolder(v)
    }

    override fun onBindViewHolder(holder: CustomHolder?, position: Int) {
        val post = homeFeed.posts.get(position)
        holder?.postTitle?.text = Html.fromHtml(post.title_plain)
        holder?.authorName?.text = post.date + "  •  " + post.author.name

        Picasso.with(holder?.itemView?.context).load(post.attachments[0].url).into(holder?.thumbnailImageView)

        holder?.post = post
    }

    override fun getItemCount(): Int {
        return homeFeed.posts.count()
    }
}

