package blogapp.bittupatel.`in`.kotlinblogapp

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class CategoryDetailAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CategoryDetailHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return CategoryDetailHolder(v)
    }

    override fun onBindViewHolder(holder: CategoryDetailHolder?, position: Int) {
        val post = homeFeed.posts.get(position)
        holder?.postTitle?.text = Html.fromHtml(post.title_plain)
        holder?.authorName?.text = post.date + "  •  " + post.author.name

        Picasso.with(holder?.itemView?.context).load(post.attachments[0].url).into(holder?.thumbnailImageView)

    }

    override fun getItemCount(): Int {
        return homeFeed.posts.count()
    }
}


class CategoryDetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var postTitle: TextView = itemView.findViewById<View>(R.id.postTitle) as TextView
    var authorName: TextView = itemView.findViewById<View>(R.id.authorName) as TextView
    var thumbnailImageView: ImageView = itemView.findViewById<View>(R.id.postThumbnail) as ImageView

}
