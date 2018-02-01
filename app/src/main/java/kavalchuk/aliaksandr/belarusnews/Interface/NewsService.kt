package kavalchuk.aliaksandr.belarusnews.Interface

import kavalchuk.aliaksandr.belarusnews.Model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created by user on 31.01.2018.
 */

interface NewsService {

//    @GET()
//    fun getNewsItem(@Url url: String): Call<News>
//
//
//    companion object Factory {
//
//        val BASE_URL = "https://api.rss2json.com/v1/api.json?rss_url="
//        val FEED_URL = "https://www.belnovosti.by/"
//        val API_KEY = "jvpmkpfghyyyxysjcfna032rpd7y9hvj072jkqsp"
//
//
//        fun create(): NewsService {
//            val retrofit = Retrofit.Builder()
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .baseUrl(BASE_URL)
//                    .build()
//
//            return retrofit.create(NewsService::class.java)
//        }
//    }
//
//    fun getAPIUrl(apiKEY: String) :  String{
//        val apiUrl = StringBuilder(FEED_URL)
//
//        return apiUrl.append("&api_key=")
//                .append(apiKEY)
//                .append("&order_dir=desc ")
//                .append("&count=10").toString()
//    }

}