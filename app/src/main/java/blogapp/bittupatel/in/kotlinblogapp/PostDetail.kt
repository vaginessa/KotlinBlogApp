package blogapp.bittupatel.`in`.kotlinblogapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        // we'll change the nav bar title.
        val intent = intent
        val navBarTitle = intent.getStringExtra(CustomHolder.POST_TITLE_KEY)
        supportActionBar?.title = navBarTitle


        val thumbnail = intent.getStringExtra(CustomHolder.POST_IMAGE_KEY)
        Picasso.with(this).load(thumbnail).into(postThumbnail)

        val title = intent.getStringExtra(CustomHolder.POST_TITLE_KEY)
        postTitle.text = Html.fromHtml(title)

        val author = intent.getStringExtra(CustomHolder.POST_AUTHOR_KEY)
        val date = intent.getStringExtra(CustomHolder.POST_DATE_KEY)
        authorName.text = date + "  •  " + author

        val content = intent.getStringExtra(CustomHolder.POST_CONTENT_KEY)
        contentBlock.text = Html.fromHtml(content)
    }
}
