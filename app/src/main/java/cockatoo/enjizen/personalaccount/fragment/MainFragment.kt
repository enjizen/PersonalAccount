package cockatoo.enjizen.personalaccount.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cockatoo.enjizen.personalaccount.R
import cockatoo.enjizen.personalaccount.model.retrofit.ProvinceModel
import cockatoo.enjizen.personalaccount.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvHelloworld.text = "สวัสดีจ้า"

        if(savedInstanceState == null) {

            getApiService()!!.getProvince()
        }


    }

    override fun provinceResponse(provinceModel: ProvinceModel) {
        super.provinceResponse(provinceModel)
        Log.i("MainFragment",Gson().toJson(provinceModel))

        provinceModel.provinces.forEach {
            it.label
        }
    }


    companion object {
        fun newInstance(): MainFragment{
            val fragment = MainFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            return fragment
        }
    }

}
