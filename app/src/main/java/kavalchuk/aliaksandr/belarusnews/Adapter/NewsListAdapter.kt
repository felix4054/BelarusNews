package kavalchuk.aliaksandr.belarusnews.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kavalchuk.aliaksandr.belarusnews.Model.Item

/**
 * Created by user on 31.01.2018.
 */

class NewsListAdapter(private val items: List<Item>, context: Context) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsListViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: NewsListViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}