package blogapp.bittupatel.`in`.kotlinblogapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import blogapp.bittupatel.`in`.kotlinblogapp.FavPost
import blogapp.bittupatel.`in`.kotlinblogapp.R
import blogapp.bittupatel.`in`.kotlinblogapp.adapters.FavAdapter
import blogapp.bittupatel.`in`.kotlinblogapp.database.Manager


class FavFragment : Fragment() {

    private lateinit var db: Manager
    private val fav: MutableList<FavPost> = ArrayList()


    companion object {
        fun newInstance(): FavFragment {
            var fragmentFav = FavFragment()
            return fragmentFav
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val rootView = inflater!!.inflate(R.layout.fragment_fav, container, false)
        val rv = rootView.findViewById<View>(R.id.recyclerView_fav) as RecyclerView
        rv.layoutManager = LinearLayoutManager(FavFragment.newInstance().context)
        rv.adapter = FavAdapter(fav)
        return rootView

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAllFavPost()
    }

    private fun getAllFavPost(): List<FavPost> {

        db = Manager(context)
        db.open()
        val cursor = db.getAllPost()
        val stringBuffer = StringBuffer()
        var favFeed: FavPost? = null

        for (i in 0 until cursor!!.count) {

            favFeed = FavPost()
            val title = cursor.getString(2)
            val date = cursor.getString(3)
            val author = cursor.getString(4)
            val thumbnail = cursor.getString(5)

            favFeed.title = title
            favFeed.date = date
            favFeed.author = author
            favFeed.thumbnail = thumbnail

            stringBuffer.append(favFeed)
            fav.add(favFeed)
            cursor.moveToNext()
        }

        db.close()
        return fav

    }
}

