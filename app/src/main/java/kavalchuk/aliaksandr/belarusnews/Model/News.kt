package kavalchuk.aliaksandr.belarusnews.Model

/**
 * Created by user on 31.01.2018.
 */

data class News (
        val status: String,
        val feed: Feed,
        val items: List<Item>
)