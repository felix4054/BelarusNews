package kavalchuk.aliaksandr.belarusnews.Model

/**
 * Created by user on 31.01.2018.
 */

data class Feed (
        val url: String,
        val title: String,
        val link: String,
        val author: String,
        val description: String,
        val image: String
)