package blogapp.bittupatel.`in`.kotlinblogapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.HomeAdapter
import blogapp.bittupatel.`in`.kotlinblogapp.HomeFeed
import blogapp.bittupatel.`in`.kotlinblogapp.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException


class HomeFragment : Fragment() {


    companion object {
        fun newInstance(): HomeFragment {
            var fragmentHome = HomeFragment()
            return fragmentHome
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_home, container, false)

        val rv = rootView.findViewById<View>(R.id.recyclerView_home) as RecyclerView
        rv.layoutManager = LinearLayoutManager(HomeFragment.newInstance().context)
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
        val url = "http://www.thetechsamachar.com/?json=get_posts"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()

                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                activity.runOnUiThread {
                    recyclerView_home.adapter = HomeAdapter(homeFeed)
                }
            }

            override fun onFailure(call: Call?, e: IOException?) {
                println("Failed to execute request")
            }
        })
    }

}



