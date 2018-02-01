package kavalchuk.aliaksandr.belarusnews.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kavalchuk.aliaksandr.belarusnews.Model.News
import kavalchuk.aliaksandr.belarusnews.R
import kotlinx.android.synthetic.main.row_news.view.*


/**
 * Created by user on 31.01.2018.
 */

class NewsListAdapter(private val news: News, context: Context) : RecyclerView.Adapter<NewsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsListViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.row_news, parent, false)

        return NewsListViewHolder(cellForRow)
    }

    override fun getItemCount(): Int {
        return news.items.size
    }

    override fun onBindViewHolder(holder: NewsListViewHolder?, position: Int) {
        val items = news.items[position]

        val thumbnailImageView = holder?.rootView?.cim_news_image
        Picasso.with(holder?.rootView?.context).load(items.thumbnail).into(thumbnailImageView)

        if (items.title.length > 65) {
            holder?.rootView?.tv_item_title?.text = items.title.substring(0, 65) + "..."
        } else {
            holder?.rootView?.tv_item_title?.text = items.title
        }

        holder?.rootView?.tv_item_time?.text = items.pubDate

        holder?.items = items
    }

}