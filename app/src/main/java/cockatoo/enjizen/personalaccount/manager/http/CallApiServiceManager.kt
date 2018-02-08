package cockatoo.enjizen.personalaccount.manager.http

import android.content.Context
import android.support.v4.app.FragmentManager
import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.manager.Contextor
import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel
import cockatoo.enjizen.personalaccount.util.DialogUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
class CallApiServiceManager(listener: CallApiServiceManagerListener, fragmentManager: FragmentManager) {

    private var context : Context? = null
    /**
     * Listener return result
     */
    private var mListener: CallApiServiceManagerListener? = listener

    /**
     * Call Api Service
     */
    private var apiService: ApiService? = null

    private var fragmentManager: FragmentManager? = fragmentManager


    fun getProvince(){
        val call = apiService!!.getProvince(context!!.resources.getString(R.string.locale))
        call.enqueue(object: Callback<ProvinceModel>{


            override fun onResponse(call: Call<ProvinceModel>?, response: Response<ProvinceModel>?) {
                if(response!!.isSuccessful){
                    mListener!!.provinceResponse(response.body()!!)
                }
                else{
                    showAlertDialog()
                }
            }

            override fun onFailure(call: Call<ProvinceModel>?, t: Throwable?) {
                showAlertDialog()
            }



        })
    }

    private fun showAlertDialog(){
        DialogUtil.showAlertDialog(fragmentManager!!,"aaaaa",R.string.ok)
    }

    init {
        this.context = Contextor.getContext()
        this.apiService = HttpManager.getService()
    }


}