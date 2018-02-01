package kavalchuk.aliaksandr.belarusnews.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import dmax.dialog.SpotsDialog
import kavalchuk.aliaksandr.belarusnews.Adapter.NewsListAdapter
import kavalchuk.aliaksandr.belarusnews.Model.News
import kavalchuk.aliaksandr.belarusnews.R
import kotlinx.android.synthetic.main.fragment_all_news.*
import okhttp3.*
import java.io.IOException

/**
 * Created by user on 31.01.2018.
 */
class EconomicsNewsFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    private val RSS_LINK = "https://www.belnovosti.by/rss/3"
    private val RSS_JSON_API = "https://api.rss2json.com/v1/api.json?rss_url="
    private val RSS_API_KEY = "&api_key=jvpmkpfghyyyxysjcfna032rpd7y9hvj072jkqsp"
    private val RSS_ORDERDIR = "&order_dir=desc"
    private val RSS_COUNT = "&count="
    private val COUNT = 20

    private var webHotURL = ""

    override fun onClick(v: View) {
        when (v.id) {
            R.id.dl_list_news -> {
//                val intent = Intent(activity, WebActivity::class.java)
//                intent.putExtra(NewsListViewHolder.ITEMS_LINK_KEY, webHotURL)
//                startActivity(intent)
            }
            else -> {
                // else condition
            }
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_all_news, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)

        rv_list_news.layoutManager = LinearLayoutManager(activity)
        rv_list_news.itemAnimator = DefaultItemAnimator()
        rv_list_news.setHasFixedSize(true)


        prepareSwipeRefreshLayout()

        dl_list_news.setOnClickListener(this)

        onRefresh()
    }

    override fun onRefresh() {
//        Handler().postDelayed(Runnable {
        fetchJSON(false)
//            srl_list_news.isRefreshing = false
//        }, 500)
    }

    private fun prepareSwipeRefreshLayout() {
        srl_list_news.setColorSchemeResources(R.color.colorPrimary, R.color.colorPrimaryDark)
        srl_list_news.setOnRefreshListener(this)
        srl_list_news.canChildScrollUp()
    }

    private fun fetchJSON(isRefreshed: Boolean) {

        val url = StringBuilder(RSS_JSON_API)
        url.append(RSS_LINK)
        url.append(RSS_API_KEY)
        url.append(RSS_ORDERDIR)
        url.append(RSS_COUNT)
        url.append(COUNT)

        if (!isRefreshed) {

            val dialog = SpotsDialog(activity, R.style.CustomSportDialog)
            dialog.show()

            val request = Request.Builder().url(url.toString()).build()
            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback {

                override fun onResponse(call: Call?, response: Response?) {

                    val body = response?.body()?.string()

                    val gson = GsonBuilder().create()
                    val news = gson.fromJson(body, News::class.java)

                    activity.runOnUiThread {
                        Picasso.with(activity).load(news.items?.get(0)?.thumbnail)
                                .into(kbv_top_image_list_news)
                        tv_top_title_list_news.text = news.items?.get(0)?.title
                        tv_top_author_list_news.text = news.items?.get(0)?.author


                        rv_list_news.adapter = NewsListAdapter(news, activity)
                        rv_list_news.adapter.notifyDataSetChanged()

                        srl_list_news.isRefreshing = false
                        dialog.dismiss()

                    }

                }

                override fun onFailure(call: Call?, e: IOException?) {
                    srl_list_news.isRefreshing = false
                    dialog.dismiss()
                    println("Failed to request")
                }
            })

        } else {
            val dialog = SpotsDialog(activity, R.style.CustomSportDialog)
            dialog.show()

            val request = Request.Builder().url(url.toString()).build()
            val client = OkHttpClient()

            client.newCall(request).enqueue(object : Callback {

                override fun onResponse(call: Call?, response: Response?) {

                    val body = response?.body()?.string()

                    val gson = GsonBuilder().create()
                    val news = gson.fromJson(body, News::class.java)

                    activity.runOnUiThread {
                        Picasso.with(activity).load(news.items?.get(0)?.thumbnail)
                                .into(kbv_top_image_list_news)
                        tv_top_title_list_news.text = news.items?.get(0)?.title
                        tv_top_author_list_news.text = news.items?.get(0)?.author


                        rv_list_news.adapter = NewsListAdapter(news, activity)
                        rv_list_news.adapter.notifyDataSetChanged()

                        srl_list_news.isRefreshing = false
                        dialog.dismiss()

                    }

                }

                override fun onFailure(call: Call?, e: IOException?) {
                    srl_list_news.isRefreshing = false
                    dialog.dismiss()
                    println("Failed to request")
                }
            })

            srl_list_news.isRefreshing = false
            dialog.dismiss()
        }

    }



}