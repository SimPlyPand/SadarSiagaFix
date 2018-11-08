package sadarsiaga.com.sadarsiaga.model

import com.google.gson.annotations.SerializedName

data class BencanaResponse(@SerializedName("result")
                         val result: List<BencanaModel>,
                           @SerializedName("message")
                         val message: String = "")