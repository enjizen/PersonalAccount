package cockatoo.enjizen.personalaccount.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import cc.cloudist.acplibrary.ACProgressFlower
import cockatoo.enjizen.personalaccount.manager.http.CallApiServiceManager
import cockatoo.enjizen.personalaccount.manager.http.CallApiServiceManagerListener
import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel
import cockatoo.enjizen.personalaccount.view.AlertDialogFragment

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
 abstract class BaseFragment : Fragment(), CallApiServiceManagerListener
                                    ,AlertDialogFragment.AlertDialogListener{



    private var apiService: CallApiServiceManager? = null
    private var dialog: ACProgressFlower? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        apiService = CallApiServiceManager(this, childFragmentManager)
    }

    protected fun getApiService(): CallApiServiceManager? {
        showLoadingDialog()
        return apiService
    }


    /**
     * Show Loading Wait Api or Other
     */
    protected fun showLoadingDialog() {

        dialog = ACProgressFlower.Builder(context)
                .build()

        // dialog.setCanceledOnTouchOutside(false);

        dialog!!.show()
    }

    /**
     * Hide Loading Wait Api or Other
     */

    protected fun hideLoadingDialog() {
        dialog!!.dismiss()
    }

    override fun onHideLoadingDialog() {
        hideLoadingDialog()
    }



    override fun onPositiveButtonClick() {

    }

    override fun provinceResponse(provinceModel: ProvinceModel) {

    }





}