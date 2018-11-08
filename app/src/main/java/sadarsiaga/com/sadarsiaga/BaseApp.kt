package sadarsiaga.com.sadarsiaga

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sadarsiaga.com.sadarsiaga.api.ApiService

class BaseApp : Application() {
    companion object {
        lateinit var service : ApiService
    }
    override fun onCreate() {
        super.onCreate()

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://sadar-siaga-be.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        service = retrofit.create(ApiService::class.java)

    }

}