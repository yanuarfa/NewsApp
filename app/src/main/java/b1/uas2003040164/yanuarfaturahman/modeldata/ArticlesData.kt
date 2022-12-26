package b1.uas2003040164.yanuarfaturahman.modeldata

import com.google.gson.annotations.SerializedName

data class ArticlesData(
    @SerializedName("articles") val data:List<NewsData>,
    @SerializedName("totalResults") val totalData:Int
)
