package cockatoo.enjizen.personalaccount.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import cockatoo.enjizen.personalaccount.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BankAccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BankAccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BankAccountFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_bank_account, container, false)
    }


    companion object {

        fun newInstance(): BankAccountFragment {
            val fragment = BankAccountFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
