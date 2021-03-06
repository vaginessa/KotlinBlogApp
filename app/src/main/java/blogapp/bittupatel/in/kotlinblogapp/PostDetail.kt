package blogapp.bittupatel.`in`.kotlinblogapp

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.webkit.WebSettings
import blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder.HomeViewHolder
import blogapp.bittupatel.`in`.kotlinblogapp.database.Manager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_detail.*

class PostDetail : AppCompatActivity() {

    lateinit var db: Manager
    var isChecked: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val intent = intent
        val navBarTitle = Html.fromHtml(intent.getStringExtra(HomeViewHolder.POST_TITLE_KEY))

        val id = intent.getIntExtra(HomeViewHolder.POST_ID, 0)

        val thumbnail = intent.getStringExtra(HomeViewHolder.POST_IMAGE_KEY)
        Picasso.with(this).load(thumbnail).into(postThumbnail)

        val title = intent.getStringExtra(HomeViewHolder.POST_TITLE_KEY)
        postTitle.text = Html.fromHtml(title)

        val author = intent.getStringExtra(HomeViewHolder.POST_AUTHOR_KEY)
        val date = intent.getStringExtra(HomeViewHolder.POST_DATE_KEY)
        authorName.text = date + "  •  " + author

        val content = intent.getStringExtra(HomeViewHolder.POST_CONTENT_KEY)

        contentBlock.settings.javaScriptEnabled = true
        contentBlock.settings.useWideViewPort = true
        contentBlock.settings.loadWithOverviewMode = true
        contentBlock.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
        contentBlock.loadData(content, "text/html", "UTF-8")

        var scrollRange = -1
        var isShow = false

        val appBarLayout = findViewById<AppBarLayout>(R.id.appbar)

        appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->

            if (scrollRange == -1) {
                scrollRange = appBarLayout.totalScrollRange
                setSupportActionBar(toolbar)
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                toolbar.title = null

            }
            if (scrollRange + verticalOffset == 0) {
                collapsing_toolbar.title = navBarTitle
                isShow = true
            } else if (isShow) {
                collapsing_toolbar.title = " "
                isShow = false
            }
        }

        db = Manager(this)
        db.open()
        val c = db.fetch(title)
        if ((c != null) && (c.count > 0)) {
            isChecked = c.getString(4)
        }
        db.close()

        if (isChecked == "true") {
            btnFav.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_48dp))
        } else {
            btnFav.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_black_48dp))
        }


        btnFav.setOnClickListener {
            if (isChecked == "true") {
                db.open()
                db.delete(title)
                db.close()
                btnFav.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_border_black_48dp))
                isChecked = "false"
            } else {
                db.open()
                db.insert(id, title, date, author, thumbnail, content, "true")
                db.close()
                btnFav.setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_black_48dp))
                isChecked = "true"
            }
        }
    }

}





