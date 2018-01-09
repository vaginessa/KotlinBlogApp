package blogapp.bittupatel.`in`.kotlinblogapp

import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso


class CategoryDetailAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomHolder>() {

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


//class CategoryDetailHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    var post: Post? = null
//
//    var postTitle: TextView = itemView.findViewById<View>(R.id.postTitle) as TextView
//    var authorName: TextView = itemView.findViewById<View>(R.id.authorName) as TextView
//    var thumbnailImageView: ImageView = itemView.findViewById<View>(R.id.postThumbnail) as ImageView
//
//    companion object {
//
//        val POST_IMAGE_KEY = "POST_IMAGE"
//        val POST_TITLE_KEY = "POST_TITLE"
//        val POST_AUTHOR_KEY = "POST_AUTHOR"
//        val POST_DATE_KEY = "POST_DATE"
//        val POST_CONTENT_KEY = "POST_CONTENT"
//
//    }
//
//    init {
//        itemView.setOnClickListener {
//            val intent = Intent(itemView.context, PostDetail::class.java)
//
//            intent.putExtra(POST_IMAGE_KEY, post?.attachments!![0].url)
//            intent.putExtra(POST_TITLE_KEY, post?.title_plain)
//            intent.putExtra(POST_AUTHOR_KEY, post?.author?.name)
//            intent.putExtra(POST_DATE_KEY, post?.date)
//            intent.putExtra(POST_CONTENT_KEY, post?.content)
//
//            itemView.context.startActivity(intent)
//        }
//    }
//}
