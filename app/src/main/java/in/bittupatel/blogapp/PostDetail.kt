package `in`.bittupatel.blogapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        // we'll change the nav bar title.
        val navBarTitle = intent.getStringExtra(CustomViewHolder.POST_TITLE_KEY)
        supportActionBar?.title = navBarTitle

        val thumbnail = intent.getStringExtra(CustomViewHolder.POST_IMAGE_KEY)
        Picasso.with(this).load(thumbnail).into(postThumbnail)

        val title = intent.getStringExtra(CustomViewHolder.POST_TITLE_KEY)
        postTitle.text = Html.fromHtml(title)

        val author = intent.getStringExtra(CustomViewHolder.POST_AUTHOR_KEY)
        val date = intent.getStringExtra(CustomViewHolder.POST_DATE_KEY)
        authorName.text = date+ "  •  " +author

        val content = intent.getStringExtra(CustomViewHolder.POST_CONTENT_KEY)
        contentBlock.text = Html.fromHtml(content)

    }

}

