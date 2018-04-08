package blogapp.bittupatel.`in`.kotlinblogapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.Category
import blogapp.bittupatel.`in`.kotlinblogapp.R
import blogapp.bittupatel.`in`.kotlinblogapp.adapters.CategoryAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.progress_bar.*
import org.json.JSONException
import org.json.JSONObject


class CategoryFragment : Fragment() {

    private var categoryRC: RecyclerView? = null
    var category: MutableList<Category?> = ArrayList()
    private lateinit var adapter: CategoryAdapter
    private lateinit var manager: GridLayoutManager
    internal var id: Int = 0
    private lateinit var title: String


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
        categoryRC = rootView.findViewById(R.id.recyclerView_cat)
        categoryRC?.layoutManager = GridLayoutManager(newInstance().context, 3)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val URL_DATA = "http://www.thetechsamachar.com/api/get_category_index/"
        val stringRequest = StringRequest(Request.Method.GET, URL_DATA,
                Response.Listener { s ->
                    try {
                        val jsonObject = JSONObject(s)
                        val array = jsonObject.getJSONArray("categories")
                        for (i in 0 until array.length()) {
                            val ob = array.getJSONObject(i)
                            id = ob.getInt("id")
                            title = ob.getString("title")
                            val catItem = Category(id, title)
                            category.add(catItem)
                        }
                        categoryRC?.adapter = CategoryAdapter(category)
                        progessBar.visibility = GONE


                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }, Response.ErrorListener { })
        val requestQueue = Volley.newRequestQueue(activity)
        requestQueue.add(stringRequest)

    }
//
//    private fun loadData() {
//
//    }




}