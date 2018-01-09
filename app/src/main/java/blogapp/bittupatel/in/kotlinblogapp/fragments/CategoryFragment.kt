package blogapp.bittupatel.`in`.kotlinblogapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.CategoryAdapter
import blogapp.bittupatel.`in`.kotlinblogapp.CategoryFeed
import blogapp.bittupatel.`in`.kotlinblogapp.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_category.*
import okhttp3.*
import java.io.IOException

class CategoryFragment : Fragment() {

    companion object {
        fun newInstance(): CategoryFragment {
            val fragmentCat = CategoryFragment()
            return fragmentCat
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_category, container, false)

        val rv = rootView.findViewById<View>(R.id.recyclerView_cat) as RecyclerView
        rv.layoutManager = LinearLayoutManager(CategoryFragment.newInstance().context)

        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchJson()
    }

    //Fetch JSON Data
    private fun fetchJson() {
        println("Attempting to Fetch JSON")

        //REST API Url
        val url = "http://www.thetechsamachar.com/?json=get_category_index"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val categoryFeed = gson.fromJson(body, CategoryFeed::class.java)

                activity.runOnUiThread {
                    recyclerView_cat.adapter = CategoryAdapter(categoryFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }
}
