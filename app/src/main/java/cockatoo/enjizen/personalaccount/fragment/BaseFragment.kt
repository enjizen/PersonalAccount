package cockatoo.enjizen.personalaccount.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import cockatoo.enjizen.personalaccount.manager.http.CallApiServiceManager
import cockatoo.enjizen.personalaccount.manager.http.CallApiServiceManagerListener
import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel
import cockatoo.enjizen.personalaccount.view.AlertDialogFragment

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
open class BaseFragment : Fragment(), CallApiServiceManagerListener
                                    ,AlertDialogFragment.AlertDialogListener{



    private var apiService: CallApiServiceManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiService = CallApiServiceManager(this, childFragmentManager)
    }

    override fun onPositiveButtonClick() {

    }

    override fun provinceResponse(provinceModel: ProvinceModel) {

    }


    fun getApiService(): CallApiServiceManager? {
        return apiService
    }


}