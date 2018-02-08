package cockatoo.enjizen.personalaccount.manager.http

import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel

/**
 * Created by wanchalermyuphasuk on 4/2/2018 AD.
 */
interface CallApiServiceManagerListener {
     fun provinceResponse(provinceModel: ProvinceModel)

     fun onHideLoadingDialog()
}