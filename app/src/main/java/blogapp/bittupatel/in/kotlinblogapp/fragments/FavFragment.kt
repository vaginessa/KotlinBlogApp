package blogapp.bittupatel.`in`.kotlinblogapp.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import blogapp.bittupatel.`in`.kotlinblogapp.R


class FavFragment : Fragment() {
    companion object {
        fun newInstance(): FavFragment {
            var fragmentFav = FavFragment()
            return fragmentFav
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_fav, container, false)
    }

}// Required empty public constructor
