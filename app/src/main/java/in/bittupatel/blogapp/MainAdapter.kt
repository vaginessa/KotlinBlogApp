package `in`.bittupatel.blogapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.post_row.view.*

/**
 * Created by bittu.dvlpr on 24/12/17.
 */

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {


    // numberOfItems
    override fun getItemCount(): Int {
        return homeFeed.posts.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        // how do we even create a view
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.post_row, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val post = homeFeed.posts.get(position)
        holder?.view?.postTitle?.text = post.title_plain

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}
