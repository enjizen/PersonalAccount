package cockatoo.enjizen.personalaccount.manager.http

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
object HttpManager {
    private const val baseUrl = "http://203.154.255.55:8080/tipinsuranceAPI-3.0/"
    private const val dataFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
    private var service: ApiService? = null


    init {
        val gson = GsonBuilder()
                .setDateFormat(dataFormat)
                .create()
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(ApiService::class.java)
    }


    fun getService() = service

}