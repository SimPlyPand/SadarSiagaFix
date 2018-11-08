package sadarsiaga.com.sadarsiaga.api

import retrofit2.Call
import retrofit2.http.GET

import sadarsiaga.com.sadarsiaga.model.BencanaResponse

interface ApiService {

    @GET("/tweet_posts")
    fun bencanaList() : Call<BencanaResponse>


}