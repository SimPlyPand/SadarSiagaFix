package sadarsiaga.com.sadarsiaga.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BencanaModel(@SerializedName("updated_at")
                        val updatedAt: String = "",
                        @SerializedName("img_url")
                        val imgUrl: String = "",
                        @SerializedName("user_tweets_id")
                        val userTweetsId: Int = 0,
                        @SerializedName("description")
                        val description: String = "",
                        @SerializedName("created_at")
                        val createdAt: String = "",
                        @SerializedName("id")
                        val id: Int = 0,
                        @SerializedName("title")
                        val title: String = "",
                        @SerializedName("tweets_id")
                        val tweetsId: Long = 0,
                        @SerializedName("url")
                        val url: String = ""):Parcelable