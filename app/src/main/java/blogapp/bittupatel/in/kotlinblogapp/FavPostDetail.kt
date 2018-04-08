package blogapp.bittupatel.`in`.kotlinblogapp

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.AppBarLayout
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.webkit.WebSettings
import blogapp.bittupatel.`in`.kotlinblogapp.ViewHolder.FavouriteViewHolder
import blogapp.bittupatel.`in`.kotlinblogapp.database.Manager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_post_detail.*

class FavPostDetail : AppCompatActivity() {

    lateinit var db: Manager
    var isChecked: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val intent = intent
        val navBarTitle = Html.fromHtml(intent.getStringExtra(FavouriteViewHolder.POST_TITLE_KEY))

        val title = intent.getStringExtra(FavouriteViewHolder.POST_TITLE_KEY)
        postTitle.text = Html.fromHtml(title)

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
            val date: String = c.getString(0)
            val author: String = c.getString(1)
            val thumbnail: String = c.getString(2)
            val content: String = c.getString(3)
            isChecked = c.getString(4)
            authorName.text = "$date  •  $author"
            Picasso.with(this).load(thumbnail).into(postThumbnail)
            contentBlock.settings.javaScriptEnabled = true
            contentBlock.settings.useWideViewPort = true
            contentBlock.settings.loadWithOverviewMode = true
            contentBlock.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING
            contentBlock.loadData(content, "text/html", "UTF-8")

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
            }
        }
    }

}





