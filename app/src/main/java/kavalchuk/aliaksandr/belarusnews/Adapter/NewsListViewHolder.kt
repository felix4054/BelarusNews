package kavalchuk.aliaksandr.belarusnews.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import kavalchuk.aliaksandr.belarusnews.Model.Item

/**
 * Created by user on 31.01.2018.
 */

class NewsListViewHolder(internal var rootView: View, var items: Item? = null) : RecyclerView.ViewHolder(rootView) {

    companion object {

        val ITEMS_LINK_KEY = "ITEMS_LINK_KEY"

    }

    init {
        rootView.setOnClickListener {
//            val intent = Intent(custView.context, ItemDetailActivity::class.java)
//
//            intent.putExtra( VIDEO_TITLE_KEY, item?.name)
//            intent.putExtra(VIDEO_ID_KEY, item?.id)
//
//            custView.context.startActivity(intent)
        }
    }
}