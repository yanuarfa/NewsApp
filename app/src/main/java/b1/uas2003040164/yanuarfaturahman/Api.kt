package b1.uas2003040164.yanuarfaturahman

import b1.uas2003040164.yanuarfaturahman.modeldata.ArticlesData
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("top-headlines?country=id&apiKey=0a25620b7acd47cda4e89b1afed20582")
    fun getNews():Call<ArticlesData>
}