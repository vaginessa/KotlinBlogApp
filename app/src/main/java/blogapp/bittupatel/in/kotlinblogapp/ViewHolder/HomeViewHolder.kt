package blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import blogapp.bittupatel.`in`.kotlinblogapp.Post
import blogapp.bittupatel.`in`.kotlinblogapp.PostDetail
import blogapp.bittupatel.`in`.kotlinblogapp.R

class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var post: Post? = null
    var postTitle: TextView = itemView.findViewById<View>(R.id.postTitle) as TextView
    var authorName: TextView = itemView.findViewById<View>(R.id.authorName) as TextView
    var thumbnailImageView: ImageView = itemView.findViewById<View>(R.id.postThumbnail) as ImageView

    companion object {

        val POST_IMAGE_KEY = "POST_IMAGE"
        val POST_TITLE_KEY = "POST_TITLE"
        val POST_AUTHOR_KEY = "POST_AUTHOR"
        val POST_DATE_KEY = "POST_DATE"
        val POST_CONTENT_KEY = "POST_CONTENT"
        val POST_ID = "POST_ID"

    }

    init {
        itemView.setOnClickListener {
            val intent = Intent(itemView.context, PostDetail::class.java)

            intent.putExtra(POST_IMAGE_KEY, post?.thumbnail_images)
            intent.putExtra(POST_TITLE_KEY, post?.title_plain)
            intent.putExtra(POST_AUTHOR_KEY, post?.author)
            intent.putExtra(POST_DATE_KEY, post?.date)
            intent.putExtra(POST_CONTENT_KEY, post?.content)
            intent.putExtra(POST_ID, post?.id)

            itemView.context.startActivity(intent)
        }
    }
}
