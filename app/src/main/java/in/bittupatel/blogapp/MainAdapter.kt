package `in`.bittupatel.blogapp

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_row.view.*

/**
 * Created by bittu.dvlpr on 24/12/17.
 */

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.posts.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        // how do we even create a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.post_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val post = homeFeed.posts.get(position)
        holder?.view?.postTitle?.text = Html.fromHtml(post.title_plain)
        holder?.view?.authorName?.text = post.date + "  •  " + post.author.name

        val thumbnailImageView = holder?.view?.postThumbnail
        Picasso.with(holder?.view?.context).load(post.attachments[0].url).into(thumbnailImageView)

        holder?.post = post
    }

}

class CustomViewHolder(val view: View, var post: Post? = null): RecyclerView.ViewHolder(view) {
    companion object {

        val POST_IMAGE_KEY = "POST_IMAGE"
        val POST_TITLE_KEY = "POST_TITLE"
        val POST_AUTHOR_KEY = "POST_AUTHOR"
        val POST_DATE_KEY = "POST_DATE"
        val POST_CONTENT_KEY = "POST_CONTENT"

    }

    init {
        view.setOnClickListener {
            val intent = Intent(view.context, PostDetail::class.java)

            intent.putExtra(POST_IMAGE_KEY, post?.attachments!![0]?.url)
            intent.putExtra(POST_TITLE_KEY, post?.title_plain)
            intent.putExtra(POST_AUTHOR_KEY, post?.author?.name)
            intent.putExtra(POST_DATE_KEY, post?.date)
            intent.putExtra(POST_CONTENT_KEY, post?.content)



            view.context.startActivity(intent)
        }
    }
}


