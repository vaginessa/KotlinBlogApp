package blogapp.bittupatel.`in`.kotlinblogapp.adapters

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.FavPost
import blogapp.bittupatel.`in`.kotlinblogapp.R
import blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder.FavouriteViewHolder
import com.squareup.picasso.Picasso


class FavAdapter(private var favFeed: List<FavPost>) : RecyclerView.Adapter<FavouriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return FavouriteViewHolder(v)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder?, position: Int) {
        val post = favFeed[position]
        holder?.postTitle?.text = Html.fromHtml(post.title)
        holder?.authorName?.text = post.date + "  •  " + post.author
        Picasso.with(holder?.itemView?.context).load(post.thumbnail).into(holder?.thumbnailImageView)

        holder?.post = post
    }

    override fun getItemCount(): Int {
        return favFeed.count()
    }
}
