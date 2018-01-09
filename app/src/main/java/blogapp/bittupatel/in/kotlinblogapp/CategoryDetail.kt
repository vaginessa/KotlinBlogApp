package blogapp.bittupatel.`in`.kotlinblogapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_category_detail.*
import okhttp3.*
import java.io.IOException

class CategoryDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_detail)

        recyclerView_catDetail.layoutManager = LinearLayoutManager(this)
        val intent = intent
        val navBarTitle = intent.getStringExtra(CategoryHolder.CATEGORY_TITLE_KEY)
        supportActionBar?.title = navBarTitle
        val id = intent.getIntExtra(CategoryHolder.CATEGORY_ID_KEY, 0)

        //REST API Url
        val url = "http://www.thetechsamachar.com/?json=get_posts&cat=" + id

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread {
                    recyclerView_catDetail.adapter = CategoryDetailAdapter(homeFeed)
                }


            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })

    }

}
