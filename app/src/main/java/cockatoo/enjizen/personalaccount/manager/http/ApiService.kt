package cockatoo.enjizen.personalaccount.manager.http


import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Wanchalerm Yuphasuk on 26/12/2017 AD.
 */

interface ApiService {

    @GET("masterdata/provincee")
    fun getProvince(@Query("lang") lang: String): Call<ProvinceModel>

    /*@GET("masterdata/amphur")
    Call<AmphurModel> getAmphur(@Query("lang") String lang, @Query("provinceId") int province_id);*/

}
