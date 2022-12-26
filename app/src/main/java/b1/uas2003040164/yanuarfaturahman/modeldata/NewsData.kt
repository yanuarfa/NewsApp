package b1.uas2003040164.yanuarfaturahman.modeldata

import com.google.gson.annotations.SerializedName

class NewsData (
    val title: String, val author: String, val description: String, val url: String,
    @SerializedName("urlToImage") val poster: String
    )