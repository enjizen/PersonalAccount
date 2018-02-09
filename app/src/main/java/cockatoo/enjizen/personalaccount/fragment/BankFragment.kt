package cockatoo.enjizen.personalaccount.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cockatoo.enjizen.personalaccount.R


/**
 * A simple [Fragment] subclass.
 */
class BankFragment : BaseFragment(){


    companion object {
        fun newInstance(): BankFragment{
            val fragment = BankFragment()
            val bundle = Bundle()
            fragment.arguments = bundle

            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =// Inflate the layout for this fragment
            inflater!!.inflate(R.layout.fragment_bank, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
    }

    private fun onRestoreInstanceState(savedInstanceState: Bundle) {

    }


}// Required empty public constructor
